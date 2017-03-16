package calendApp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = { "events", "friends" })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonView(JsonViews.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String lastName;

	@JsonView(JsonViews.Public.class)
	@OneToOne
	private Location location;

	@Column(name = "email", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String email;

	@Column(name = "password", nullable = false, length = 76)
	private String password;

	@Column(name = "image", nullable = true, length = 150)
	@JsonView(JsonViews.Public.class)
	private String image;

	@ManyToMany
	@OrderBy("date")
	@JsonView(JsonViews.Public.class)
	@JsonIgnoreProperties({ "creator,participants", "location" })
	private List<Event> events = new ArrayList<>();

	@ManyToMany
	@OrderBy("last_name")
	@JsonView(JsonViews.Public.class)
	@JsonIgnoreProperties({ "friends", "password", "events", "location" })
	private List<User> friends = new ArrayList<>();

	public User() {
	}

	public User(String firstName, String lastName, Location location, String email, String password, List<Event> events,
			List<User> friends) {
		this(null, firstName, lastName, location, email, password, events, friends);
	}

	public User(Long id, String firstName, String lastName, Location location, String email, String password,
			List<Event> events, List<User> friends) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.email = email;
		this.password = password;
		this.events = events;
		this.friends = friends;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", location=" + location
				+ ", email=" + email + ", password=" + password + ", events=" + events + ", friends=" + friends + "]";
	}

}
