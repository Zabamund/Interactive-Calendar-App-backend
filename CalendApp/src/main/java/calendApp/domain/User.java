package calendApp.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
*
* @author Adrian Gross
*/

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(of = "email")
@ToString(exclude = { "password" })
public class User  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	public static final String ENTITY_GRAPH_USER_WITH_ROLES = "UserWithRoles";

	@Id
	@JsonView(JsonViews.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="first_name", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String firstName;
	
	@Column(name="last_name",nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String lastName;
	
	@Column(name="location",nullable = true)
	@JsonView(JsonViews.Public.class)
	private Long location;
	
	@Column(name="email",nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String email;
	
	@Column(name="password",nullable = false, length = 50)
	@JsonView(JsonViews.NewUser.class)
	private String password;
	
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@OrderBy("date")
	private List<Event> events = new ArrayList<>();*/
	
	/*@ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
	@OrderBy("lastName")
	private List<User> friends = new ArrayList<>();*/
	
	
	

	public User() {
	}


	public User(String firstName, String lastName, Long location, String email, String password) {
		this(null, firstName,  lastName,  location,  email,  password);
	}
	
	public User(Long userId, String firstName, String lastName, Long location, String email, String password) {
		this.id = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.email = email;
		this.password = password;
		/*this.events = events;*/
		/*this.friends = friends;*/
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


	public Long getUserId() {
		return id;
	}


	public void setUserId(Long userId) {
		this.id = userId;
	}


	public Long getLocation() {
		return location;
	}


	public void setLocation(Long location) {
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


	/*public List<Event> getEvents() {
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
	}*/


	

}
