package calendApp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calendApp.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	public Event findById(Long id);

	public Event findByEventName(String eventName);

	public void deleteById(Long id);

	public List<Event> findAll();

	public List<Event> findAllEventsByDate(LocalDate date);
}
