package calendApp.service;


import java.time.LocalDate;
import java.util.List;

import calendApp.domain.Event;
import calendApp.domain.Location;
import calendApp.domain.User;


public interface EventService {
		
		public Event registerNewEvent(Event event);

		public Event findById(Long eventId);
		
		public List<Event> findAll();
		
		public void deleteById(Long eventId);

		public Event findByEventName(String eventName);
		
		public List<User> findAllParticipantsById(Long eventId);
		
		public List<Event> findAllEventsByLocation(Location location);
		
		public List<Event> findAllEventsByDate(LocalDate date);
		
		public List<Event> findAllEventsByCity(String city);

	}




