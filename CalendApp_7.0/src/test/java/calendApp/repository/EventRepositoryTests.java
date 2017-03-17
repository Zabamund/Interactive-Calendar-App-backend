
package calendApp.repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import calendApp.AbstractCalendappIntegrationTests;
import calendApp.domain.EntityTestUtils;
import calendApp.domain.Event;
import calendApp.domain.User;
import calendApp.service.UserService;

public class EventRepositoryTests extends AbstractCalendappIntegrationTests {

	/**
	 * Number of events created in test-data.sql.
	 */
	private static final int NUM_TEST_EVENTS = 2;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	UserService service;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void count() {
		assertThat(eventRepository.count()).isEqualTo(NUM_TEST_EVENTS);
	}

	@Test
	public void save() {
		saveOneEvent();
		assertNumEvents(NUM_TEST_EVENTS + 1);
	}

	@Test
	public void findByEventId() {

		assertThat(eventRepository.findById(111L)).isNotNull();
		assertThat(eventRepository.findById(999999L)).isNull();
	}

	@Test
	public void findByEventName() {

		assertThat(eventRepository.findByEventName("party2")).isNotNull();
		assertThat(eventRepository.findByEventName("party5")).isNull();
	}

	@Test
	public void deleteByEventId() {
		assertNumEvents(NUM_TEST_EVENTS);
		Long eventId = eventRepository.findByEventName("party1").getId();
		eventRepository.delete(eventId);
		eventRepository.flush();
		assertNumEvents(NUM_TEST_EVENTS-1);
	}
	
	
	@Test
	public void findAllEventsByDate(){
		
		List<String> events = eventRepository.findAllEventsByDate(LocalDate.parse("2017-02-02"))
				.stream().map(Event::getEventName).collect(toList());
		assertThat(events).containsExactlyInAnyOrder("party2");
	}


	public void saveOneEvent() {

		User user = userRepository.findById(1L);
		Event event = EntityTestUtils.createEvent1();
		event.setCreator(user);
				eventRepository.save(event);
	}

	private void assertNumEvents(int expected) {
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "events")).isEqualTo(expected);
	}

}
