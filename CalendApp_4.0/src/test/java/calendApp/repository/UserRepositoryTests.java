
package calendApp.repository;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import calendApp.AbstractCalendappIntegrationTests;
import calendApp.domain.User;

public class UserRepositoryTests extends AbstractCalendappIntegrationTests {

	/**
	 * Number of users created in test-data.sql.
	 */
	private static final int NUM_TEST_USERS = 2;

	@Autowired
	UserRepository repository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void count() {
		assertThat(repository.count()).isEqualTo(NUM_TEST_USERS);
	}

	@Test
	public void save() {
		saveOneUser();
		assertNumUsers(NUM_TEST_USERS + 1);
	}

	@Test
	public void findById() {

		Long id = repository.findByFirstNameAndLastName("jane", "doe").getId();
		assertThat(repository.findById(id)).isNotNull();
		assertThat(repository.findById(999999L)).isNull();

	}

	@Test
	public void deleteById() {

		assertNumUsers(NUM_TEST_USERS);
		Long userId = repository.findByFirstNameAndLastName("jane", "doe").getId();
		repository.delete(userId);
		repository.flush();
		assertNumUsers(NUM_TEST_USERS - 1);
	}

	@Test
	public void findByFirstNameAndLastName() {

		User user = repository.findById(2L);
		assertThat(user).isEqualTo(repository.findByFirstNameAndLastName("jane", "doe"));
	}

	@Test
	public void findAll() {

		List<String> userNames = repository.findAll().stream().map(User::getFirstName).collect(toList());
		assertThat(userNames).containsExactlyInAnyOrder("john", "jane");

	}

	private void saveOneUser() {
		repository.save(calendApp.domain.EntityTestUtils.createUser1());
	}

	private void assertNumUsers(int expected) {
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "users")).isEqualTo(expected);
	}

}
