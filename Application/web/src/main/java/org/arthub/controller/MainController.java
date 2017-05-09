package org.arthub.controller;

import org.arthub.controller.response.LoginResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/arthub1")
public class MainController {

	@GetMapping
	public LoginResponse index(){
		LoginResponse response = new LoginResponse();
		response.setStatus(200);
		response.setMessage("Beniamin Savu");
		return response;
	}
}
