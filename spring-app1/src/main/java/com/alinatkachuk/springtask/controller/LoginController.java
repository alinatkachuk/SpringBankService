package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alinatkachuk.springtask.entity.User;

@Controller
public class LoginController {
	
	private final UserDAO userDAO;

	@Autowired
	public LoginController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping ("/users")
	public String usersPage(Model model) {
		model.addAttribute("allUsers", userDAO.showUsers());
		return "usersPage";
	}

	@GetMapping ("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "registerPage";
	}

	@PostMapping ("/users/new")
	public String doRegister(@ModelAttribute ("user") User user) {
		userDAO.saveUsers(user);
		return "redirect:/users";
	}
}
