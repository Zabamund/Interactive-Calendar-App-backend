package calendApp.service;

import calendApp.domain.Location;

public interface LocationService {
	
	public void createLocation(Location location);
	
	public Location findById(Long locationId);

	public void deleteById(Long locationId);
		
//	public void update(String street, Long locationId);
	
	
}
