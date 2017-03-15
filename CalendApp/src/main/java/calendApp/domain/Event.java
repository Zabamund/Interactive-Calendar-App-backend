package calendApp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
=======
>>>>>>> master
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;
<<<<<<< HEAD
import lombok.ToString;
=======
/**
*
* @author Adrian Gross
*/
>>>>>>> master

@Data
@Entity
@Table(name = "events")
@EqualsAndHashCode(exclude = "id")
<<<<<<< HEAD
@ToString(exclude = { "participants", "creator" })
public class Event implements Serializable {
=======
public class Event  implements Serializable {
	
>>>>>>> master

	private static final long serialVersionUID = 1L;

	@Id
	@JsonView(JsonViews.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
<<<<<<< HEAD

	@Column(name = "event_name", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String eventName;

	@ManyToOne(targetEntity = User.class, optional = false)
	private User creator;

	// yyyy-MM-dd.
	@Column(name = "date", nullable = false)
=======
	
	@Column(name="event_name", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String eventName;
	
	
	@Column(name="creator",nullable = false)
	@JsonView(JsonViews.Public.class)
	private Long creator;
	
	@Column(name="date",nullable = false)
>>>>>>> master
	@JsonView(JsonViews.Public.class)
	private LocalDate date;

	// hh:mm:ss
	@Column(name = "time", nullable = false)
	@JsonView(JsonViews.Public.class)
	private LocalTime time;
<<<<<<< HEAD

	@Column(name = "description", nullable = false, length = 100)
	@JsonView(JsonViews.Public.class)
	private String description;

	@OneToMany
	@OrderBy("last_name")
	private List<User> participants = new ArrayList<>();

=======
	
	
	@Column(name="description",nullable = false, length = 100)
	@JsonView(JsonViews.Public.class)
	private String description;
	
	
	
	/*
	@ManyToMany(mappedBy = "events", cascade = CascadeType.ALL)
	private List<User> participants = new ArrayList<>();*/
	
	
	@Column(name="location",nullable = false)
>>>>>>> master
	@JsonView(JsonViews.Public.class)
	@OneToOne
	private Location location;

	@Column(name = "open", nullable = false)
	@JsonView(JsonViews.Public.class)
	private boolean open;

	
	
	
	
	public Event() {
	}
<<<<<<< HEAD

	public Event(String eventName, User creator, LocalDate date, LocalTime time, String description,
			List<User> participants, Location location, Boolean open) {
		this(null, eventName, creator, date, time, description, participants, location, open);
	}

	public Event(Long id, String eventName, User creator, LocalDate date, LocalTime time, String description,
			List<User> participants, Location location, Boolean open) {
		this.id = id;
=======
	
	public Event(String eventName, Long creator, LocalDate date,LocalTime time, String description,
			 Long locationId, Boolean open) {
		this(null, eventName,  creator,  date,time,   description,
				   locationId,  open);
	}
	
	public Event(Long eventId, String eventName, Long creator, LocalDate date, LocalTime time, String description,
			 Long locationId, Boolean open) {
		this.id = eventId;
>>>>>>> master
		this.eventName = eventName;
		this.creator = creator;
		this.date = date;
		this.time = time;
		this.description = description;
<<<<<<< HEAD
		this.participants = participants;
		this.location = location;
		this.open = open;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
=======
		//this.participants = participants;
		this.location = locationId;
		this.open = open;
	}

	public Long getEventId() {
		return id;
	}

	public void setEventId(Long eventId) {
		this.id = eventId;
>>>>>>> master
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
/*
	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}
<<<<<<< HEAD

	public Location getLocation() {
=======
*/
	public Long getLocation() {
>>>>>>> master
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

}
