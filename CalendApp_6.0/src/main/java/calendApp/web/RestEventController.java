package calendApp.web;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMethodCall;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;

import com.fasterxml.jackson.annotation.JsonView;

import calendApp.domain.Event;
import calendApp.domain.JsonViews;
import calendApp.domain.User;
import calendApp.service.EventService;
import calendApp.service.UserService;

/**
*
* @author Adrian Gross
*/

@RestController
@RequestMapping("/events")
public class RestEventController {

	private final EventService eventservice;
	private final UserService userservice;

	@Autowired
	public RestEventController(EventService eventservice, UserService userservice) {
		this.eventservice = eventservice;
		this.userservice = userservice;

	}

	@JsonView(JsonViews.Public.class)
	@GetMapping("/{eventId}")
	public Event retrieveEventById(@PathVariable Long eventId) {
		System.out.println(eventservice.findById(eventId).getParticipants().size());
		return eventservice.findById(eventId);
	}
	
	@JsonView(JsonViews.Public.class)
	@GetMapping
	public List<Event> listAllEvents() {
		return this.eventservice.findAll();
	}
	
	@PostMapping("/{eventId}/toggle")
	public void joinEvent(@PathVariable Long eventId, @RequestBody Long userId) {
		User user = userservice.findById(userId);
		Event event = eventservice.findById(eventId);
		if (user.getEvents().contains(event)) {
			this.userservice.leaveEvent(userId, eventId);
		}else {
			this.userservice.joinEvent(userId, eventId);
		}
		/*
		UriComponents uriComponents = fromMethodCall(
				on(getClass()).retrieveEventById(eventId)).build();

			return ResponseEntity.created(uriComponents.encode().toUri()).build();
		*/
		
	}
	
	@PostMapping("/{eventId}/delete")
	public void deleteUser(@PathVariable Long eventId) {
			this.eventservice.deleteById(eventId);
	}
		
	
	@JsonView(JsonViews.NewUser.class)
	@PostMapping("/register")
	public HttpEntity<Void> registerNewEvent(@RequestBody Event postedEvent) {
		Event savedEvent = eventservice.registerNewEvent(postedEvent);

		UriComponents uriComponents = fromMethodCall(
			on(getClass()).retrieveEventById(savedEvent.getId())).build();

		return ResponseEntity.created(uriComponents.encode().toUri()).build();
	}
}
