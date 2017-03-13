
package calendApp.service;

import java.time.LocalDate;
import java.util.List;

import calendApp.domain.Event;
import calendApp.domain.User;


public interface UserService {

	User findById(Long id);
	
	public void deleteById(Long userId);

	User findByFirstNameAndLastName(String firstName, String lastName);

	public List<Event> findAllEventsOfUserById(Long userId);
	
	public List<Event> findAllEventsOfUserByDate(Long userId, LocalDate date);
	
	public void registerNewUser(User user);
	
	public void update(User User);
	
	public void joinEvent(Long userId,Long eventId);
	
	public void leaveEvent(Long userId,Long eventId);
	

}
