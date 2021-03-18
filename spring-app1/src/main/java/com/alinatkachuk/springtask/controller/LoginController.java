package com.alinatkachuk.springtask.controller;

import com.alinatkachuk.springtask.dao.UserDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.alinatkachuk.springtask.entity.User;

@Controller
public class LoginController {

	public static User user = null;
	private final UserDAO userDAO;

	@Autowired
	public LoginController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping ("/users")
	public String usersPage(Model model) {
		model.addAttribute("allUsers", userDAO.allUsers());
		return "usersPage";
	}

	@GetMapping ("/register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "registerPage";
	}

	@PostMapping ("/users/new")
	public String doRegister(@ModelAttribute ("user") User user) {
		userDAO.addUser(user);
		return "redirect:/users";
	}

	@GetMapping ("/authorization")
	public String authorizationPage(Model model) {
		model.addAttribute("user", new User());
		return "registerPage";
	}

	@PostMapping ("/authorization/login")
	public String doAuthorization(@ModelAttribute ("user") @Valid User user, BindingResult bindingResult) {
		if (userDAO.getUserByEmail(user.getEmail())==null) {
			bindingResult.addError(new ObjectError("user", new String[] {"All fields must be filled"},
					null, null));
			return "redirect:/authorization";
		} else {
			return "afterAuthorization";
		}
	}
}
