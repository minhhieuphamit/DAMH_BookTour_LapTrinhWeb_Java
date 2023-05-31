package hieukientung.booktour.repository;

import hieukientung.booktour.model.BillTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillTourRepository extends JpaRepository<BillTour, Long> {
}
