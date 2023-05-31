package hieukientung.booktour.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "destination_point", schema = "book_tour")
public class DestinationPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "destination_name", nullable = false, length = 50)
    private String destinationName;

}