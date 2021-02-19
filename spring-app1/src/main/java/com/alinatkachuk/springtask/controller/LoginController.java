package com.alinatkachuk.springtask.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.alinatkachuk.springtask.entity.User;

@Controller
public class LoginController {
	
	List<User> users = new ArrayList<>();
	
	@GetMapping ("/register")
	public String registerPage() {
		return "register.html";
	}

	@GetMapping ("/users")
	public String usersPage() {
		return "usersPage.html";
	}
	
	@PostMapping ("/users/new")
	public void doRegister() {
		
	}
}
