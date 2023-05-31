package hieukientung.booktour.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tour_type", schema = "book_tour")
public class TourType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_type_id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "tour_type_name", nullable = false, length = 50)
    private String tourTypeName;

    @Column(name = "status")
    private Integer status;

}