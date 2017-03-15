package calendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calendApp.domain.Location;
<<<<<<< HEAD
=======
/**
*
* @author Adrian Gross
*/

>>>>>>> master

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

<<<<<<< HEAD
	public Location findById(Long locationId);
=======
	public Location findById(Long Id);
	

	
	


>>>>>>> master
}
