package hieukientung.booktour.repository;

import hieukientung.booktour.model.DestinationPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationPointRepository extends JpaRepository<DestinationPoint, Long> {
}
