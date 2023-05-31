package hieukientung.booktour.repository;

import hieukientung.booktour.model.DeparturePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeparturePointRepository extends JpaRepository<DeparturePoint, Long> {
}
