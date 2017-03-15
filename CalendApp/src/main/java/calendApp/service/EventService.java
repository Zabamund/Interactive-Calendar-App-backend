package calendApp.service;


import java.time.LocalDate;
import java.util.List;

import calendApp.domain.Event;
import calendApp.domain.Location;
import calendApp.domain.User;
/**
*
* @author Adrian Gross
*/

public interface EventService {
		
		public Event registerNewEvent(Event event);

		Event findById(Long eventId);
		
		public void deleteById(Long eventId);

		Event findByEventName(String eventName);
		
		public List<User> findAllParticipantsById(Long eventId);
		
		public List<Event> findAllEventsByLocation(Location location);
		
		public List<Event> findAllEventsByDate(LocalDate date);
		
		public List<Event> findAll();
		
		public void update(Event event);
		

	}
