package hieukientung.booktour.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "discount", schema = "book_tour")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id", nullable = false)
    private Long id;

    @Column(name = "discount_month")
    private LocalDate discountMonth;

    @Column(name = "percentage")
    private Double percentage;

    @Size(max = 50)
    @Column(name = "discount_name", length = 50)
    private String discountName;

}