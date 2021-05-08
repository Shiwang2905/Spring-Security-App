package com.shiwang.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String showHome() {
		return "homepage";
	}
	
	@GetMapping("/loginuser")
	public String loginUser() {
		return "Login";
	}
	
	@GetMapping("/managers")
	public String checkManagerAccess() {
		
		return "manager-page";
	}
	
	@GetMapping("/admin")
	public String checkAdminAccess() {
		
		return "admin-cred";
	}
	
	@GetMapping("/access-denied")
	public String denyAccess() {
		
		return "accessdenied";
	}
	
}
