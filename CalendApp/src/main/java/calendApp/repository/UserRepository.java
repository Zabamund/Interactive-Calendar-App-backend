package calendApp.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import calendApp.domain.Event;
import calendApp.domain.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	public User findByUserId(Long userId);
	
	public void deleteByUserId(Long userId);

	@Modifying
	@Query("update User u set u.firstname = ?1 where u.userId = ?2")
	public void update(String firstName,String userId);
	
	public User findByFirstNameAndLastName(String firstName, String lastName);

	public List<Event> findAllByUserId(Long userId);
	

}


//
//public void registerNewUser(User user);
//
//public User update(User User);
//


