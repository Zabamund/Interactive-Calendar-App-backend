package calendApp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendApp.domain.Event;
import calendApp.domain.Location;
import calendApp.domain.User;
import calendApp.repository.EventRepository;
<<<<<<< HEAD
=======
/**
*
* @author Adrian Gross
*/
>>>>>>> master

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
<<<<<<< HEAD

		return this.eventRepository.save(event);
=======
		this.eventRepository.save(event);
		return event;
>>>>>>> master
		

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
<<<<<<< HEAD

		List<User> userList = this.eventRepository.findById(eventId).getParticipants();
		return userList;
=======
		return this.eventRepository.findAllParticipantsById(eventId);
>>>>>>> master
	}

	@Override
	public List<Event> findAllEventsByLocation(Location location) {

		List<Event> eventsList = this.eventRepository.findAll();

		List<Event> newEventList = new ArrayList<Event>();
		eventsList.forEach(item -> {
			if (item.getLocation().equals(location)) {
				newEventList.add(item);
			}
		});

		return newEventList;
	}

	@Override
	public List<Event> findAllEventsByDate(LocalDate date) {

		List<Event> eventsList = this.eventRepository.findAll();
		
		List<Event> newEventList = new ArrayList<Event>();
		eventsList.forEach(
				item->{
				if (item.getDate().equals(date)) {
					newEventList.add(item);
				}	
				});
		return newEventList;
	}

	@Override
<<<<<<< HEAD
	public List<Event> findAll() {
=======
	public void update(Event event) {
	this.eventRepository.save(event);
>>>>>>> master
		
		return this.eventRepository.findAll();
	}

	@Override
	public List<Event> findAll() {
		return this.eventRepository.findAll();
	}

}
