package calendApp.domain;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "events")
@EqualsAndHashCode(exclude = "eventId")
public class Event  implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@JsonView(JsonViews.Public.class)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eventId;
	
	@Column(name="event_name", nullable = false, length = 50)
	@JsonView(JsonViews.Public.class)
	private String eventName;
	
	@ManyToOne(optional = false)
	@Column(name="creator",nullable = false)
	@JsonView(JsonViews.Public.class)
	private User creator;
	
	@Column(name="date",nullable = false)
	@JsonView(JsonViews.Public.class)
	private LocalDate date;
	
	@Column(name="time",nullable = false)
	@JsonView(JsonViews.Public.class)
	private LocalTime time;
	
	@Column(name="description",nullable = false, length = 100)
	@JsonView(JsonViews.Public.class)
	private String description;
	
	@OneToMany(mappedBy = "events", cascade = CascadeType.ALL)
	@OrderBy("lastName")
	private List<User> participants = new ArrayList<>();
	
	
	@Column(name="location",nullable = false)
	@JsonView(JsonViews.Public.class)
	private Long location;

	
	@Column(name="open",nullable = false)
	@JsonView(JsonViews.Public.class)
	private Boolean open;

	public Event() {
	}
	
	public Event(String eventName, User creator, LocalDate date, LocalTime time, String description,
			List<User> participants, Long locationId, Boolean open) {
		this(null, eventName,  creator,  date,  time,  description,
				 participants,  locationId,  open);
	}
	
	public Event(Long eventId, String eventName, User creator, LocalDate date, LocalTime time, String description,
			List<User> participants, Long locationId, Boolean open) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.creator = creator;
		this.date = date;
		this.time = time;
		this.description = description;
		this.participants = participants;
		this.location = locationId;
		this.open = open;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}

	public Long getLocation() {
		return location;
	}

	public void setLocation(Long location) {
		this.location = location;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}
	
	
}
	