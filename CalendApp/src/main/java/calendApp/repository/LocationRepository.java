package calendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendApp.domain.Location;



@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	public Location findById(Long locationId);
	
	@Modifying
	@Query("update location l set l.street= ?1 where l.locationId = ?2")
	public void update(String street, Long locationId);
	
	


}
