package calendApp.web;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import calendApp.domain.Event;
import calendApp.domain.JsonViews;
import calendApp.domain.User;
import calendApp.service.EventService;
/**
*
* @author Adrian Gross
*/

@RestController
@RequestMapping("/events")
public class RestEventController {

	private final EventService eventservice;

	@Autowired
	public RestEventController(EventService eventservice) {
		this.eventservice = eventservice;

	}

	@JsonView(JsonViews.Public.class)
	@GetMapping("/{eventId}")
	public Event retrieveEventById(@PathVariable Long eventId) {
		return eventservice.findById(eventId);
	}
	
	@JsonView(JsonViews.Public.class)
	@GetMapping
	public List<Event> all() {
		return this.eventservice.findAll();
	}
	
	@JsonView(JsonViews.NewUser.class)
	@PostMapping("/{eventId}/toggel")
	public HttpEntity<Void> registerNewEvent(@RequestBody Event postedEvent) {
		Event savedevent = this.eventservice.registerNewEvent(postedEvent);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/register")
<<<<<<< HEAD
				.buildAndExpand(savedevent.getId()).toUri();
=======
				.buildAndExpand(savedevent.getEventId()).toUri();
>>>>>>> master
		return ResponseEntity.created(location).build();
	}

}
