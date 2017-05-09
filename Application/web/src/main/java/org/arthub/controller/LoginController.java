package org.arthub.controller;

import org.arthub.controller.response.LoginResponse;
import org.arthub.controller.response.SignupResponse;
import org.arthub.persistence.model.UserModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@CrossOrigin
//@RequestMapping("/login")
public class LoginController {
	
	
	
	@PostMapping
	public void processNewUserFrom(@RequestBody UserModel newUser) {

		LoginResponse response = new LoginResponse();
		response.setMessage("Thank you for registering. Please confirm your email within 1 day. You may proceed to login");
		response.setStatus(200);
	}
}
