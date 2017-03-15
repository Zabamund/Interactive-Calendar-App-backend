package calendApp.service;

import calendApp.domain.Location;
/**
*
* @author Adrian Gross
*/
public interface LocationService {
	
	public void createLocation(Location lcoation);
	
	public Location findById(Long Id);

	public void deleteById(Long Id);
		
	public void update(Location lcoation);
	
	
}
