package calendApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendApp.domain.Location;
import calendApp.repository.LocationRepository;
/**
*
* @author Adrian Gross
*/
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
	public Location findById(Long Id) {

		return this.locationRepository.findById(Id);
	}

	@Override
	public void update(Location location) {

		this.locationRepository.save(location);

	}

	@Override
	public void createLocation(Location location) {
		this.locationRepository.save(location);

	}

	@Override
	public void deleteById(Long Id) {

		this.locationRepository.delete(Id);

	}

}
