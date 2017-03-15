package calendApp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calendApp.domain.Event;
<<<<<<< HEAD

=======
import calendApp.domain.User;

/**
*
* @author Adrian Gross
*/
>>>>>>> master
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	public Event findById(Long id);

	public Event findByEventName(String eventName);

	public void deleteById(Long id);

	public List<Event> findAll();

<<<<<<< HEAD
	public List<Event> findAllEventsByDate(LocalDate date);
}
=======
		public Event findById(Long eventId);
		public Event findByEventName(String eventName);
		public void deleteById(Long eventId);
		
		public List<User> findAllParticipantsById(Long eventId);
		public List<Event> findAllEventsByLocation(Long locationId);
		public List<Event> findAllEventsByDate(LocalDate date);
	}
>>>>>>> master
