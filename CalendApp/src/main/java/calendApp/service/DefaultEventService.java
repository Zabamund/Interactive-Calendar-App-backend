package calendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendApp.domain.Event;
import calendApp.domain.Location;
import calendApp.domain.User;
import calendApp.repository.EventRepository;
/**
*
* @author Adrian Gross
*/

@Transactional(readOnly = true)
@Service
public class DefaultEventService implements EventService {
	
	private final EventRepository eventRepository;
	
	@Autowired
	public DefaultEventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Transactional(readOnly = false)
	@Override
	public Event registerNewEvent(Event event) {
		this.eventRepository.save(event);
		return event;
		
	}

	@Override
	public Event findById(Long eventId) {
		return this.eventRepository.findById(eventId);
	}

	@Override
	public void deleteById(Long eventId) {
		this.eventRepository.delete(eventId);
		
	}

	@Override
	public Event findByEventName(String eventName) {
		return this.eventRepository.findByEventName(eventName); 
	}

	@Override
	public List<User> findAllParticipantsById(Long eventId) {
		return this.eventRepository.findAllParticipantsById(eventId);
	}

	@Override
	public List<Event> findAllEventsByLocation(Location location) {
		return this.eventRepository.findAllEventsByLocation(location.getLocationId());
	}

	@Override
	public List<Event> findAllEventsByDate(LocalDate date) {
		return this.eventRepository.findAllEventsByDate(date);
	}

	@Override
	public void update(Event event) {
	this.eventRepository.save(event);
		
	}

	@Override
	public List<Event> findAll() {
		return this.eventRepository.findAll();
	}

}
