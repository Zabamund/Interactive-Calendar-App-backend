package calendApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendApp.domain.Location;
import calendApp.repository.LocationRepository;

@Transactional(readOnly = true)
@Service
public class DefaultLocationService implements LocationService {

	private final LocationRepository locationRepository;

	@Autowired
	public DefaultLocationService(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}

	@Override
	public Location findById(Long locationId) {

		return locationRepository.findById(locationId);
	}

	@Override
	public void createLocation(Location location) {
		locationRepository.save(location);

	}

	@Override
	public void deleteById(Long locationId) {

		locationRepository.delete(locationId);

	}

}
