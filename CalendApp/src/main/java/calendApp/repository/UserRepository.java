package calendApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calendApp.domain.User;
<<<<<<< HEAD
=======
/**
*
* @author Adrian Gross
*/

>>>>>>> master

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

<<<<<<< HEAD
	public User findById(Long userId);

	public List<User> findAll();

	public void deleteById(Long userId);
=======
	
	Optional<User> findById(Long id);
	
	public void deleteById(Long userId);

	
	public User findByFirstNameAndLastName(String firstName, String lastName);

	public List<Event> findAllById(Long Id);
	
>>>>>>> master

	public User findByFirstNameAndLastName(String firstName, String lastName);
}
