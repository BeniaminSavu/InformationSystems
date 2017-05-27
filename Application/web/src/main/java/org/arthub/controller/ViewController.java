package org.arthub.controller;

import org.arthub.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/res")
	public String getResourcePage(){
		return "resources";
	}
	
	@RequestMapping("/resourceDetails")
	public String getResourceDetailsPage(){
		return "resourceDetails";
	}
	
	@RequestMapping("/manageMembers")
	public String getMembers(){
		return "manageMembers";
	}
	
	@RequestMapping("/editMember")
	public String getEditMember(){
		return "editMember";
	}
	
	@RequestMapping("/editProfile")
	public String getEditProfile(){
		return "editProfile";
	}
	
	@RequestMapping("/reports")
	public String getReportsPage(){
		return "reports";
	}
}

