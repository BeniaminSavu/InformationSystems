package org.arthub.controller;

import java.util.List;

import org.arthub.controller.response.LoginResponse;
import org.arthub.service.UserService;
import org.arthub.service.data.UserData;
import org.arthub.service.data.UserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("arthub/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<UserData> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/fullname")
	public UserName getFulLName(){
		return userService.getFullName();
	}
}