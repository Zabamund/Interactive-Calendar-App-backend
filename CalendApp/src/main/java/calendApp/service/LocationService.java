package calendApp.service;

import calendApp.domain.Location;
/**
*
* @author Adrian Gross
*/
public interface LocationService {
	
	public void createLocation(Location location);
	
	public Location findById(Long Id);

	public void deleteById(Long Id);
		
<<<<<<< HEAD
//	public void update(String street, Long locationId);
=======
	public void update(Location lcoation);
>>>>>>> master
	
	
}
