package calendApp.service;


import java.time.LocalDate;
import java.util.List;

import calendApp.domain.Event;
import calendApp.domain.Location;
import calendApp.domain.User;


public interface EventService {
		
		public void registerNewEvent(Event event);

		Event findByEventId(Long eventId);
		
		public void deleteById(Long eventId);

		Event findByEventName(String eventName);
		
		public List<User> findAllParticipantsByEventId(Long eventId);
		
		public List<Event> findAllEventsByLocation(Location location);
		
		public List<Event> findAllEventsByDate(LocalDate date);
		
		public void update(Event event);
		

	}
