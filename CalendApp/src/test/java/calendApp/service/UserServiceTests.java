package calendApp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
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


public class UserServiceTests extends AbstractCalendappIntegrationTests{
	
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
	JdbcTemplate jdbcTemplate;

	@Test
	public void registerNewUser(){
		
		assertNumUsers(2);
		Location location1 = new Location("bahnhof", "1234", "8008", "aarau", "schweiz", "", "");
		locationRepository.save(location1);
		locationRepository.flush();
		User user = new User("Jimmy", "Doe",location1,"jimmy@email.com","testing",null,null);
	
		userService.registerNewUser(user);
		userRepository.flush();
		
		assertNumUsers(3);
	}
	
	@Test
	public void findById(){
		
		User user = userService.findByFirstNameAndLastName("john", "smith");
		assertThat(user).isEqualTo(userService.findById(user.getId()));

	}
	
	@Test
	public void deleteById(){
		
		User user = userService.findByFirstNameAndLastName("john", "smith");
		userService.deleteById(user.getId());
		userRepository.flush();
		
		assertNumUsers(1);
	}

	@Test
	public void findByFirstNameAndLastName(){
		
		User user = userService.findById(1L);
		assertThat(user).isEqualTo(userService.findByFirstNameAndLastName("john", "smith"));
		
	}
	

	@Test
	public void findAllEventsOfUserById(){
		
		User user = userService.findByFirstNameAndLastName("john", "smith");
		Event event = eventService.findByEventName("party1");
		Event event2 = eventService.findByEventName("party2");
		
		assertThat(userService.findAllEventsOfUserById(user.getId())).containsExactlyInAnyOrder(event);
		
//		Join an event 
		userService.joinEvent(user.getId(),event2.getId());	
		assertThat(userService.findAllEventsOfUserById(user.getId())).containsExactlyInAnyOrder(event,event2);
	
//		Leave an Event
		userService.leaveEvent(user.getId(),event2.getId());	
		assertThat(userService.findAllEventsOfUserById(user.getId())).containsExactlyInAnyOrder(event);

	
	}
	
	@Test
	public void findAllEventsOfUserByDate(){
		
		User user = userService.findByFirstNameAndLastName("john", "smith");
		List<Event> events = userService.findAllEventsOfUserByDate(user.getId(), LocalDate.parse("2017-01-01"));
		Event event = eventService.findByEventName("party1");
		assertThat(events).containsExactlyInAnyOrder(event);
		
		//Join an event
		Event event2 = eventService.findByEventName("party2");
		userService.joinEvent(user.getId(),event2.getId());
		userRepository.flush();
		List<Event> events2 = userService.findAllEventsOfUserByDate(user.getId(), LocalDate.parse("2017-02-02"));
		assertThat(events2).containsExactlyInAnyOrder(event2);
	}
	
	@Test 
	public void findAll(){
		
		assertNumUsers(2);
	}
	
	private void assertNumUsers(int expected) {
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "users")).isEqualTo(expected);
	}
	


}
