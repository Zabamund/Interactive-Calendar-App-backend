package calendApp.repository;

import java.time.LocalDate;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendApp.domain.Event;
import calendApp.domain.User;

/**
*
* @author Adrian Gross
*/
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


		public Event findById(Long eventId);
		public Event findByEventName(String eventName);
		public void deleteById(Long eventId);
		
		public List<User> findAllParticipantsById(Long eventId);
		public List<Event> findAllEventsByLocation(Long locationId);
		public List<Event> findAllEventsByDate(LocalDate date);
	}
