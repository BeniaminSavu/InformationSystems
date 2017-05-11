package org.arthub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/index")
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping("/loginPage")
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping("/registerPage")
	public String getRegisterPage() {
		return "register";
	}
}

