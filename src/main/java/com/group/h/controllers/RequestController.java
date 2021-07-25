package com.group.h.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.h.beans.Request;
import com.group.h.beans.User;
import com.group.h.services.RequestService;
import com.group.h.services.UserService;
import com.group.h.services.ViewService;

@Controller
public class RequestController {
	@Autowired 
	RequestService requestService;
	@Autowired
	ViewService viewService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/issuedBooks")
	public String showIssuedBooks(Model m, HttpServletResponse response, HttpServletRequest request) {
		
		User u = userService.isLoggedIn(request);
		List<Request> books;
		

		books = requestService.getIssuedBookList();
		m.addAttribute("title", "All issued books");

		
		m.addAttribute("bookList", books);
		return viewService.model(m, request).view("showIssuedBooks");
	}
	
	@RequestMapping("/books/request")
	public String showBookRequestForm(Model m, HttpServletRequest request) {
			
		m.addAttribute("book", new Request());
		return viewService.model(m, request).view("bookRequestForm");
	}
	
	@RequestMapping(value = "/books/issue", method = RequestMethod.POST)
	public String processBookRequest(@ModelAttribute("request") Request r, Model m, HttpServletRequest request) {
		
		User u = userService.isLoggedIn(request);
		
		requestService.issueBook(u, r);
		
		return "redirect:/issuedBooks";
	}
	
	@RequestMapping("/books/{bookId}/return")
	public String returnBook(Model m, @PathVariable String bookId, HttpServletRequest request) {
			
		requestService.returnBook(bookId);
		
		return "redirect:/issuedBooks";
	}
	
}
