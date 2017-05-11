package org.arthub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/index")
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping("/signin")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String getRegisterPage() {
		return "register";
	}
	
	@RequestMapping("/home")
	public String getLoggedUserPage() {
		return "loggedUser";
	}
	
	@RequestMapping("/newEvent")
	public String getNewEventPage(){
		return "newEvent";
	}
	
	@RequestMapping("/newResource")
	public String getNewResourcePage(){
		return "newResource";
	}
}

