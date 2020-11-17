package com.hwan.ExBoot04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwan.ExBoot04.model.User;
import com.hwan.ExBoot04.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "account/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "account/register";
	}
	
	@PostMapping("/register")
	public String register(User user) {
		userService.save(user);
		return "redirect:/";
	}
	
}
