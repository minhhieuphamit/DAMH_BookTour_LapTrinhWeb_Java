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

public interface CartService {
    public List<CartItem> getCartItems();

    public void clearCart();

    public void addToCart(Tour tour);

    public void updateCartItem(Long productId, int quantity);

    public void removeFromCart(Long productId);

    @Transactional
    public void orderCart(User user);

    public int getCartCount();
}