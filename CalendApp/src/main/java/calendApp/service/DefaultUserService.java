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
	public void registerNewUser(User user) {
		
		// Make sure we are saving a new user and not accidentally 
		// updating an existing user.
		user.setUserId(null);
		
		// A new user cannot have events before the account exists.
		user.getEvents().clear();

		this.userRepository.save(user);
	}

	@Override
	public User findById(Long userId) {
		return this.userRepository.findByUserId(userId);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return this.userRepository.findByFirstNameAndLastName(firstName, lastName);
	}


	@Override
	public void deleteById(Long userId) {
		User user = this.userRepository.findByUserId(userId);
		this.userRepository.delete(user);
		
	}

	@Override
	public List<Event> findAllEventsOfUserById(Long userId) {
		User user = this.userRepository.findByUserId(userId);
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
	}

	
	public void update(User user) {
		this.userRepository.update(user.getFirstName(), user.getLastName());
	}

	@Override
	public void joinEvent(Long userId,Long eventId) {

			User user=  userRepository.findByUserId(userId);
			Event event = eventRepository.findByEventId(eventId);
			user.getEvents().add(event);
			event.getParticipants().add(user);
	}

	@Override
	public void leaveEvent(Long userId,Long eventId){

	User user=  userRepository.findByUserId(userId);
	Event event = eventRepository.findByEventId(eventId);
	user.getEvents().remove(event);
	event.getParticipants().remove(user);
	
	
	}

}