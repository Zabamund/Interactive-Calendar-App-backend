package calendApp.repository;

import java.time.LocalDate;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendApp.domain.Event;
import calendApp.domain.User;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


		public Event findByEventId(Long eventId);
		public Event findByEventName(String eventName);
		public void deleteByEventId(Long eventId);
		
		@Modifying
		@Query("update events e set e.event_name = ?1 where e.eventId = ?2")
		public void update(String eventName, Long eventId);
		
		//"All" returns a list
		
		public List<User> findAllParticipantsByEventId(Long eventId);
		public List<Event> findAllEventsByLocation(Long locationId);
		public List<Event> findAllEventsByDate(LocalDate date);
	}
