package calendApp.service;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import calendApp.AbstractCalendappIntegrationTests;
import calendApp.domain.Event;
import calendApp.domain.Location;
import calendApp.domain.User;
import calendApp.repository.EventRepository;
import calendApp.repository.LocationRepository;
import calendApp.repository.UserRepository;

public class EventServiceTests extends AbstractCalendappIntegrationTests {

	@Autowired
	UserService userService;

	@Autowired
	EventService eventService;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	LocationService locationService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void registerNewEvent() {

		assertNumEvents(2);

		// create location
		Location location1 = new Location("bahnhof", "1234", "8008", "aarau", "schweiz", "", "");
		locationService.createLocation(location1);
		locationRepository.flush();

		// create user
		User user = new User("Jimmy", "Doe", location1, "jimmy@email.com", "testing", null, null);
		userService.registerNewUser(user);
		userRepository.flush();

		// create event
		Event event = new Event("party10", user, LocalDate.parse("2017-03-03"), LocalTime.parse("03:03:03"), "testing",
				null, location1, true);
		eventService.registerNewEvent(event);
		eventRepository.flush();

		assertNumEvents(3);

	}

	@Test
	public void findById() {

		Event event = eventService.findByEventName("party1");
		assertThat(event).isEqualTo(eventService.findById(event.getId()));

	}

	@Test
	public void deleteById() {

		assertNumEvents(2);
		Event event = eventService.findByEventName("party1");
		eventService.deleteById(event.getId());
		eventRepository.flush();
		assertNumEvents(1);
	}

	@Test
	public void findByEventName() {

		Event event = eventService.findById(111L);
		assertThat(event).isEqualTo(eventService.findByEventName("party1"));

	}

	@Test
	public void findAllEventsByLocation() {

		Location location = locationService.findById(22L);

		List<String> eventNames = eventService.findAllEventsByLocation(location).stream().map(Event::getEventName)
				.collect(toList());

		assertThat(eventNames).containsExactlyInAnyOrder("party2");

	}

	@Test
	public void findAllEventsByDate() {

		List<String> eventNames = eventService.findAllEventsByDate(LocalDate.parse("2017-01-01")).stream()
				.map(Event::getEventName).collect(toList());

		assertThat(eventNames).containsExactlyInAnyOrder("party1");

	}

	@Test
	public void findAllParticipantsById() {

		Event event = eventService.findByEventName("party1");
	
		// Join an event - 1 participant
		User user1 = userService.findByFirstNameAndLastName("jane", "doe");
		userService.joinEvent(user1.getId(), event.getId());
		
		assertThat(eventService.findAllParticipantsById(event.getId())).containsExactlyInAnyOrder(user1);
		
		// Join another event  - 2 participants
		User user2 = userService.findByFirstNameAndLastName("john", "smith");
		userService.joinEvent(user2.getId(), event.getId());

		// Leave an Event
		userService.leaveEvent(user2.getId(), event.getId());
		assertThat(eventService.findAllParticipantsById(event.getId())).containsExactlyInAnyOrder(user1);


	}
	
	@Test 
	public void findAll(){
		
		assertNumEvents(2);
	}
	

	public void assertNumEvents(int expected) {
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "events")).isEqualTo(expected);
	}

}
