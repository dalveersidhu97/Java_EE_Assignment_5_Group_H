package com.group.h.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group.h.beans.Book;
import com.group.h.beans.Login;
import com.group.h.beans.Request;
import com.group.h.beans.User;
import com.group.h.services.BookService;
import com.group.h.services.RequestService;
import com.group.h.services.UserService;
import com.group.h.services.ViewService;

@Controller
public class BookController {
	
	@Autowired
	ViewService viewService;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

	
	@RequestMapping("/addBook")
	public String showAddBook(@ModelAttribute("book") Book B,Model m, HttpServletRequest request) {

		return viewService.model(m, request).view("addBookForm");
	}
	
	@RequestMapping(value = "/addBookProcess", method = RequestMethod.POST)
	public String processAddBook(@ModelAttribute("book") Book B, Model m, HttpServletResponse response) {
		
		bookService.addBook(B);
		
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/books")
	public String showBooks(Model m, HttpServletResponse response, HttpServletRequest request) {
		
		List<Book> books = bookService.getBookList();
		
		m.addAttribute("bookList", books);
		m.addAttribute("title", "All books");
		return viewService.model(m, request).view("showBooks");
	}
	
	
}




















