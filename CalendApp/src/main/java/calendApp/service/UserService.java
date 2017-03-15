
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
	
	public void deleteById(Long userId);

	public User findByFirstNameAndLastName(String firstName, String lastName);

	
	public User registerNewUser(User user);
	
	public void update(User User);
	
	public List<User> findAll();
	
/*
	public List<Event> findAllEventsOfUserById(Long userId);
	
	public List<Event> findAllEventsOfUserByDate(Long userId, LocalDate date);
	
	public void joinEvent(Long userId,Long eventId);
	
	public void leaveEvent(Long userId,Long eventId);
	
*/
}
