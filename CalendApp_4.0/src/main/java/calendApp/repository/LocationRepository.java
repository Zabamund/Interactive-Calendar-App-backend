package calendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calendApp.domain.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	public Location findById(Long locationId);
}
