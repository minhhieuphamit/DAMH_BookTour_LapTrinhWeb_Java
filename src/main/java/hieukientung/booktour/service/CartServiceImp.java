package hieukientung.booktour.service;

import hieukientung.booktour.model.*;
import hieukientung.booktour.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@SessionScope
public class CartServiceImp implements CartService {
    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }

    public void addToCart(Tour tour) {
        CartItem existingCartItem = null;
        CartItem newItem = new CartItem();
        boolean replaceItem = false;

        for (CartItem cartItem : cartItems) {
            if (cartItem.getId().equals(tour.getId())) {
                existingCartItem = cartItem;
                break;
            }
        }

        if (existingCartItem != null) {
            // Tour đã tồn tại trong giỏ hàng, thực hiện thêm số lượng
            existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
        } else {
            // Tour chưa tồn tại trong giỏ hàng, thực hiện thay thế
            newItem.setId(tour.getId());
            newItem.setName(tour.getTourName());
            newItem.setImage(tour.getImage());
            newItem.setPrice(tour.getPrice());
            newItem.setQuantity(1);

            replaceItem = true;
        }

        if (replaceItem) {
            // Xóa bỏ id tour cũ nếu có trong giỏ hàng
            for (CartItem cartItem : cartItems) {
                if (!cartItem.getId().equals(tour.getId())) {
                    cartItems.remove(cartItem);
                    break;
                }
            }

            // Thêm id tour mới vào giỏ hàng
            cartItems.add(newItem);
        }
    }

    public void updateCartItem(Long productId, int quantity) {
        CartItem findCart = cartItems.stream()
                .filter(item -> item.getId().equals(productId))
                .findFirst().orElse(null);
        if (findCart != null) {
            findCart.setQuantity(quantity);
        }
    }

    public void removeFromCart(Long productId) {
        cartItems.removeIf(cartItem -> cartItem.getId().equals(productId));
    }


    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional
    public void orderCart(User user) {
        // Create a new Order
        Orders order = new Orders();
        order.setOrderDate(new Date());
        order.setIsPaid(false);
        order.setUser(user);
        // Iterate over cart items and create OrderDetails
        List<OrdersDetail> orderDetails = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            OrdersDetail orderDetail = new OrdersDetail();

            orderDetail.setOrder(order);
            orderDetail.setPrice(cartItem.getPrice().longValue());
            orderDetail.setQuantity(cartItem.getQuantity());

            orderDetails.add(orderDetail);

            order.setTotalAmount(cartItem.getAmount());
        }
        // Set order details in the order
        order.setOrderDetails(orderDetails);
        // Set tourId from cartId (because it was assigned by tourId before)
        Tour tour = new Tour();
        tour.setId(cartItems.get(0).getId());
        order.setTour(tour);

        // Save the order to the database
        ordersRepository.save(order);
        // Clear the cart
        clearCart();
    }

    public int getCartCount() {
        return cartItems.size();
    }
}