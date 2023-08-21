package hieukientung.booktour.repository;

import hieukientung.booktour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    @Query("SELECT t FROM Tour t WHERE t.departure.id = :departurePoint AND t.destination.id = :destinationPoint")
    List<Tour> searchTour(@Param("departurePoint") String departurePoint, @Param("destinationPoint") String destinationPoint);

    @Query("SELECT t FROM Tour t WHERE t.departure.id = :departurePoint AND t.destination.id = :destinationPoint AND t.dateStart = :dateStart AND t.dateEnd = :dateEnd")
    List<Tour> searchTour(@Param("departurePoint") String departurePoint, @Param("destinationPoint") String destinationPoint, @Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd);
}
