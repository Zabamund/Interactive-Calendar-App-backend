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

import calendApp.domain.JsonViews;
import calendApp.domain.User;
import calendApp.service.UserService;

/**
*
* @author Adrian Gross
*/
@RestController
@RequestMapping("/users")
public class RestUserController {

	private final UserService userservice;

	@Autowired
	public RestUserController(UserService userService) {
		this.userservice = userService;

	}

	@JsonView(JsonViews.Public.class)
	@GetMapping("/{userId}")
	public User retrieveUserById(@PathVariable Long userId) {
		return this.userservice.findById(userId);
	}
	
	@PostMapping("/{userId}/toggle")
	public void addFriend(@PathVariable Long friendId, @RequestBody Long userId) {
		User friend = userservice.findById(friendId);
		User user = userservice.findById(userId);
		if (user.getFriends().contains(friend)) {
			this.userservice.removeFriend(userId, friendId);
		}else {
			this.userservice.addFriend(userId, friendId);
		}
	}
	
	@PostMapping("/{userId}/delete")
	public void deleteUser(@PathVariable Long userId) {
			this.userservice.deleteById(userId);
	}
	

	@JsonView(JsonViews.Public.class)
	@GetMapping
	public List<User> listAllUsers() {
		return this.userservice.findAll();
	}
	
	@JsonView(JsonViews.NewUser.class)
	@PostMapping("/register")
	public HttpEntity<Void> registerNewUser(@RequestBody User postedUser) {
		User savedUser = userservice.registerNewUser(postedUser);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/register")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	
}
