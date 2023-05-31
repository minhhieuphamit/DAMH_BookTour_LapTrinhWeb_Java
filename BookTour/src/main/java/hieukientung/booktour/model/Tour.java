package hieukientung.booktour.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tour", schema = "book_tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "tour_name", length = 50)
    private String tourName;

    @Column(name = "price", precision = 18, scale = 2)
    private BigDecimal price;

    @Column(name = "departure_time")
    private Instant departureTime;

    @Column(name = "return_time")
    private Instant returnTime;

    @Column(name = "status")
    private Integer status;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id")
    private DestinationPoint destination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_id")
    private DeparturePoint departure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_type_id")
    private TourType tourType;

}