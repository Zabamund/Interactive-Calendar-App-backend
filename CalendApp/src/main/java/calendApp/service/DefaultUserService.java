package calendApp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import calendApp.domain.Event;
import calendApp.domain.User;
import calendApp.repository.EventRepository;
import calendApp.repository.UserRepository;

/**
*
* @author Adrian Gross
*/

@Transactional(readOnly = true)
@Service
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;
	private final EventRepository eventRepository;

	@Autowired
	public DefaultUserService(UserRepository userRepository,EventRepository eventRepository ) {
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
	}
	
	@Transactional(readOnly = false)
	@Override
	public User registerNewUser(User user) {
		
		// Make sure we are saving a new user and not accidentally 
		// updating an existing user.
		user.setUserId(null);
		
		// A new user cannot have events before the account exists.
		/*user.getEvents().clear();*/

		this.userRepository.save(user);
		return user;
	}

	@Override
	public User findById(Long userId) {
		return this.userRepository.findById(userId).get();
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return this.userRepository.findByFirstNameAndLastName(firstName, lastName);
	}


	@Override
	public void deleteById(Long userId) {
		User user = userRepository.findById(userId).get();
		this.userRepository.delete(user);
		
	}
	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	/*@Override
	public List<Event> findAllEventsOfUserById(Long userId) {
		User user = this.userRepository.findByUserId(userId).get();
		return user.getEvents();
	}

	@Override
	public List<Event> findAllEventsOfUserByDate(Long userId, LocalDate date) {
		List<Event> eventList = this.userRepository.findAllByUserId(userId);
		List<Event> newEventList = new ArrayList<Event>();
		eventList.forEach(
				item->{
				if (item.getDate().equals(date)) {
					newEventList.add(item);
				}	
				});
		return newEventList;
	}*/

	
	public void update(User user) {
		this.userRepository.save(user);
	}

	/*@Override
	public void joinEvent(Long userId,Long eventId) {

			User user=  this.userRepository.findByUserId(userId).get();
			Event event = this.eventRepository.findByEventId(eventId);
			user.getEvents().add(event);
			event.getParticipants().add(user);
	}

	@Override
	public void leaveEvent(Long userId,Long eventId){

	User user=  this.userRepository.findByUserId(userId).get();
	Event event = this.eventRepository.findByEventId(eventId);
	user.getEvents().remove(event);
	event.getParticipants().remove(user);
	
	
	}*/

}