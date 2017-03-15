package calendApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	private final UserService userService;

	@Autowired
	public RestUserController(UserService userService) {
		this.userService = userService;

	}

	@JsonView(JsonViews.Public.class)
	@GetMapping("/{userId}")
	public User retrieveUserById(@PathVariable Long userId) {
		return this.userService.findById(userId);
	}
	
	@JsonView(JsonViews.Public.class)
	@GetMapping
	public List<User> all() {
		return this.userService.findAll();
	}
	
	
}
