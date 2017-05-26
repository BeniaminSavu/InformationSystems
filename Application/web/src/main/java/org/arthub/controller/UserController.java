package org.arthub.controller;

import java.util.List;

import org.arthub.controller.response.LoginResponse;
import org.arthub.persistence.model.UserModel;
import org.arthub.service.UserService;
import org.arthub.service.data.UserData;
import org.arthub.service.data.UserInfo;
import org.arthub.service.data.UserName;
import org.arthub.service.data.UsernameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("arthub/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public List<UserData> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/fullname")
	public UserName getFulLName() {
		return userService.getFullName();
	}
	
	@GetMapping("/all/username")
	public List<UsernameData> getUsersUsername() {
		return userService.getAllUsersUsername();
	}
	
	@GetMapping("/info/{id}")
	public UserInfo getUserInfo(@PathVariable("id") int id) {
		return userService.getUserInfo(id);
	}


	@PostMapping("/delete")
	public LoginResponse deleteUser(@RequestBody UserModel user) {
		userService.deleteUser(user.getUsername());
		LoginResponse response = new LoginResponse();
		response.setMessage("buyaa");
		response.setStatus(200);
		return response;
	}
	
	@PostMapping("/update/{id}")
	public LoginResponse updateUser(@RequestBody UserInfo user, @PathVariable("id") int id) {
		userService.updateUser(user, id);
		LoginResponse response = new LoginResponse();
		response.setMessage("buyaa");
		response.setStatus(200);
		return response;
	}
}
