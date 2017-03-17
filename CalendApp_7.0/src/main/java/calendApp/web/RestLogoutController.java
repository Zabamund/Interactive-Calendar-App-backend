package calendApp.web;

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
@RequestMapping("/logout")
public class RestLogoutController {

	private final UserService userService;

	@Autowired
	public RestLogoutController(UserService userService) {
		this.userService = userService;

	}
	
	@JsonView(JsonViews.Public.class)
	@GetMapping
	public User retrieveEventById(@PathVariable Long userId) {
		return userService.findById(userId);
	}
	
}