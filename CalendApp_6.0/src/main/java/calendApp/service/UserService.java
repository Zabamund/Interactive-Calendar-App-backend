
package calendApp.service;

import java.time.LocalDate;
import java.util.List;

import calendApp.domain.Event;
import calendApp.domain.User;


public interface UserService {

	public User findById(Long id);
	
	public List<User> findAll();
	
	public void deleteById(Long userId);

	public User findByFirstNameAndLastName(String firstName, String lastName);

	public List<Event> findAllEventsOfUserById(Long userId);
	
	public List<Event> findAllEventsOfUserByDate(Long userId, LocalDate date);
	
	public User registerNewUser(User user);
	
	public void joinEvent(Long userId,Long eventId);
	
	public void leaveEvent(Long userId,Long eventId);
	
	public void addFriend(Long userId,Long friendId);
	
	public void removeFriend(Long userId,Long friendId);
	
	public List<User> findUserByName(String name);
	

}
