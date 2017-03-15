
package calendApp.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class EntityTestUtils {

	
	public static Location createlocation1() {
		Location location1 = new Location("bahnhof", "1234", "8008", "aarau", "schweiz", "", "");
		return location1;
	}
	
	public static User createUser1() {
		Location location1 = new Location("bahnhof", "1234", "8008", "aarau", "schweiz", "", "");
		User user1 = new User("Jimmy", "Doe",location1,"jimmy@email.com","testing",null,null);
		return user1;
	}

	public static Event createEvent1() {

		return new Event("party 3", createUser1(),
				LocalDate.parse("2017-03-01"),
				LocalTime.parse("02:03:04"),
				"party 3 desc",null, createlocation1(),true);
	
	}
}
