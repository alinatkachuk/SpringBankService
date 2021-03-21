package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.UserDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.alinatkachuk.springtask.entity.User;

@Controller
public class LoginController {

	public static User userForLogin = null;
	private final UserDAO userDAO;

	@Autowired
	public LoginController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping("/users")
	public String usersPage(Model model) {
		model.addAttribute("allUsers", userDAO.allUsers());
		return "usersPage";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "registerPage";
	}

	@PostMapping("/users/new")
	public String doRegister(@ModelAttribute("user") User user) {
		userDAO.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/authorize")
	public String authorizationPage(Model model) {
		model.addAttribute("user", new User());
		return "authorizePage";
	}

	@PostMapping("/users/login")
	public String doAuthorization(@ModelAttribute("user") @Valid User user,
								  BindingResult bindingResult) {
		User userByEmail = userDAO.getUserByEmail(user.getEmail());
		if (bindingResult.hasErrors()) {
			return "authorizePage";
		} else if ((userByEmail.getPassword()).equals(user.getPassword())==true) {
			user = userForLogin;
			return "afterAuthorize";
		}
		return "authorizePage";
	}

}
