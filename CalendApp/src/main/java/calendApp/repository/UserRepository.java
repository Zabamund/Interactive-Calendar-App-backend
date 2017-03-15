package calendApp.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calendApp.domain.Event;
import calendApp.domain.User;
/**
*
* @author Adrian Gross
*/


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findById(Long id);
	
	public void deleteById(Long userId);

	
	public User findByFirstNameAndLastName(String firstName, String lastName);

	public List<Event> findAllById(Long Id);
	

}


//
//public void registerNewUser(User user);
//
//public User update(User User);
//


