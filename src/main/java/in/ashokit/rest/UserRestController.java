package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.DashboardCard;
import in.ashokit.bindings.LoginForm;
import in.ashokit.bindings.UserAccForm;
import in.ashokit.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {
		String status = userService.login(loginForm);
		if (status.equals("success")) {
			return "redirect:/dashboard?email=" + loginForm.getEmail();
		} else {
			return status;
		}
	}

	@GetMapping("/dashboard")
	public ResponseEntity<DashboardCard> buildDashboard(@RequestParam("email") String email) {
		UserAccForm user = userService.getUserByEmail(email);
		DashboardCard dashboardCard = userService.fetchDashboardInfo();
		dashboardCard.setUser(user);
		return new ResponseEntity<>(dashboardCard, HttpStatus.OK);
	}
}
