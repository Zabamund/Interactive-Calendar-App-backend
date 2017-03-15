package calendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendApp.domain.Location;
/**
*
* @author Adrian Gross
*/


@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	public Location findById(Long Id);
	

	
	


}
