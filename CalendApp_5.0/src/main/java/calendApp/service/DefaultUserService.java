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
	public DefaultUserService(UserRepository userRepository, EventRepository eventRepository) {
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
	}

	@Transactional(readOnly = false)
	@Override
	public User registerNewUser(User user) {

		return this.userRepository.saveAndFlush(user);
	}

	@Override
	public User findById(Long userId) {
		return this.userRepository.findById(userId);
	}

	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return this.userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public void deleteById(Long userId) {
		User user = this.userRepository.findById(userId);

			List<Event>events= this.eventRepository.findAll();
			for (Event event : events) {
				if(event.getCreator().equals(user))
					this.eventRepository.delete(event);
			}

		this.userRepository.delete(user);

	}

	@Override
	public List<Event> findAllEventsOfUserById(Long userId) {
		User user = this.userRepository.findById(userId);
		return user.getEvents();
	}

	@Override
	public List<Event> findAllEventsOfUserByDate(Long userId, LocalDate date) {

		List<Event> eventList = this.userRepository.findById(userId).getEvents();
		List<Event> newEventList = new ArrayList<Event>();
		eventList.forEach(item -> {
			if (item.getDate().equals(date)) {
				newEventList.add(item);
			}
		});
		return newEventList;
	}

	@Override
	public void joinEvent(Long userId, Long eventId) {

		User user = userRepository.findById(userId);
		Event event = eventRepository.findById(eventId);

		if (user.getEvents().isEmpty()) {
			List<Event> eventsList = new ArrayList<>();
			user.setEvents(eventsList);
			user.getEvents().add(event);
			
			
		} else {
			user.getEvents().add(event);
		}

		if (event.getParticipants().isEmpty()) {
			List<User> userList = new ArrayList<>();
			event.setParticipants(userList);
			event.getParticipants().add(user);

		} else {
			event.getParticipants().add(user);
		}
	}

	@Override
	public void leaveEvent(Long userId, Long eventId) {

		User user = userRepository.findById(userId);
		Event event = eventRepository.findById(eventId);

		if (user.getEvents().isEmpty() || event.getParticipants().isEmpty()) {

		} else {
			user.getEvents().remove(event);
			event.getParticipants().remove(user);
		}
	}

	@Override
	public void addFriend(Long userId, Long friendId) {
		
		User user = userRepository.findById(userId);
		User friend = userRepository.findById(friendId);
		
		if (user.getFriends().isEmpty()) {	
			List<User> userList = new ArrayList<>();
			user.setFriends(userList);
			user.getFriends().add(friend);

		} else {
			user.getFriends().add(friend);
		}

	}

	@Override
	public void removeFriend(Long userId, Long friendId) {

		User user = userRepository.findById(userId);
		User friend = userRepository.findById(friendId);

		if (user.getFriends().isEmpty()) {

		} else {
			user.getFriends().remove(friend);
		}

	}

	@Override
	public List<User> findAll() {
		
		return this.userRepository.findAll();
	}

}