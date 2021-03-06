package org.arthub.controller;

import org.arthub.controller.response.LoginResponse;
import org.arthub.service.UserService;
import org.arthub.service.data.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/arthub/user")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	
}
