package calendApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calendApp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

	public User findById(Long userId);

	public List<User> findAll();

	public void deleteById(Long userId);

	public User findByFirstNameAndLastName(String firstName, String lastName);
}
