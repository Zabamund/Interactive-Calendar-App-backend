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

		return this.eventRepository.save(event);

	}

	@Override
	public Event findById(Long eventId) {
		return this.eventRepository.findById(eventId);
	}

	@Override
	public void deleteById(Long eventId) {

//		Delete Event from User.events
		
		List<User> participantsList = this.eventRepository.findById(eventId).getParticipants();
		Event e = this.eventRepository.findById(eventId);

		for (User user : participantsList) {
			user.getEvents().remove(e);
		}

		this.eventRepository.delete(eventId);
	}

	@Override
	public Event findByEventName(String eventName) {
		return this.eventRepository.findByEventName(eventName);
	}

	@Override
	public List<User> findAllParticipantsById(Long eventId) {

		List<User> userList = this.eventRepository.findById(eventId).getParticipants();
		return userList;
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
		eventsList.forEach(item -> {
			if (item.getDate().equals(date)) {
				newEventList.add(item);
			}
		});
		return newEventList;
	}

	@Override
	public List<Event> findAll() {

		return this.eventRepository.findAll();
	}

	@Override

	public List<Event> findAllEventsByCity(String city) {

		List<Event> newEventList = new ArrayList<Event>();

		this.eventRepository.findAll()

				.forEach(item -> {

					if (item.getLocation().getCity().equalsIgnoreCase(city))

						newEventList.add(item);

				});

		return newEventList;

	}

}
