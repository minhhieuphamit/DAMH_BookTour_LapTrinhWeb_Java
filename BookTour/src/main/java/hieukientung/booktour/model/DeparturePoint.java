package hieukientung.booktour.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departure_point", schema = "book_tour")
public class DeparturePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departure_id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "departure_name", nullable = false, length = 50)
    private String departureName;

}