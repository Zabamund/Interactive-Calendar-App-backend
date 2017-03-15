
package calendApp.service;

import java.time.LocalDate;
import java.util.List;

import calendApp.domain.Event;
import calendApp.domain.User;
/**
*
* @author Adrian Gross
*/

public interface UserService {

	public User findById(Long id);
<<<<<<< HEAD
	
	public List<User> findAll();
=======
>>>>>>> master
	
	public void deleteById(Long userId);

	public User findByFirstNameAndLastName(String firstName, String lastName);

	
<<<<<<< HEAD
	public List<Event> findAllEventsOfUserByDate(Long userId, LocalDate date);
	
	public User registerNewUser(User user);
=======
	public User registerNewUser(User user);
	
	public void update(User User);
>>>>>>> master
	
	public List<User> findAll();
	
/*
	public List<Event> findAllEventsOfUserById(Long userId);
	
	public List<Event> findAllEventsOfUserByDate(Long userId, LocalDate date);
	
	public void joinEvent(Long userId,Long eventId);
	
	public void leaveEvent(Long userId,Long eventId);
	
<<<<<<< HEAD
	public void addFriend(Long userId,Long friendId);
	
	public void removeFriend(Long userId,Long friendId);
	

=======
*/
>>>>>>> master
}
