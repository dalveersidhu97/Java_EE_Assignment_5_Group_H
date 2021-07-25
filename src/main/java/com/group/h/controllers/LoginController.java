package com.group.h.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.h.beans.Login;
import com.group.h.beans.User;
import com.group.h.services.UserService;
import com.group.h.services.ViewService;

@Controller
public class LoginController {
	
	@Autowired
	ViewService viewService;
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public String showLogin(Model m, HttpServletRequest request) {
		m.addAttribute("login", new Login());
		return viewService.model(m).view("loginForm");
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("login") Login login, Model m, HttpServletResponse response) {

		
		// validate the user and redirect to welcome page
		if (userService.validateUser(login) != null) {

			response.addCookie(new Cookie("username", login.getUsername()));
			response.addCookie(new Cookie("token", login.getPassword()));

			System.out.println(login.getPassword());
			System.out.println(login.getUsername());

			return "redirect:/";
		}
		// Otherwise show error message
		m.addAttribute("message", "Invalid username or password!");
		return viewService.model(m).view("loginForm");
	}
}
