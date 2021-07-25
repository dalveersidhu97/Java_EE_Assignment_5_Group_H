package com.group.h.controllers;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group.h.beans.Login;
import com.group.h.beans.User;
import com.group.h.services.UserService;
import com.group.h.services.ViewService;

/**
 * 
 * @author Group-H
 * @date 25 July, 2021
 * @description Controller class for root routes such as '/', '/welcome',
 *              '/logout'. It checks if the user is logged In and serves the
 *              profile page or login page accordingly.
 */

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired
	ViewService viewService;
	@RequestMapping("/")
	public String showHome(@ModelAttribute Login l, Model m, HttpServletRequest request) {

		User u = userService.isLoggedIn(request);
		if (u != null) {
			m.addAttribute("user", u);
			return "redirect:/books";
		}
		
		return "redirect:/login";
	}

	@RequestMapping("/logout")
	public String logout(Model m, HttpServletResponse response) {

		Cookie username = new Cookie("username", "");
		username.setMaxAge(0);
		Cookie token = new Cookie("token", "");
		token.setMaxAge(0);
		response.addCookie(username);
		response.addCookie(token);
		return "redirect:/login";
	}

}
