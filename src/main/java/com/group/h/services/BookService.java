package com.group.h.services;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.h.beans.*;
import com.group.h.dao.*;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description This class interact with userDao bean to provide a layer of
 *              abstraction.
 * 
 */

public class BookService {
	@Autowired
	public BookDao bookDao;

	public void addBook (Book b) {
		bookDao.addBook(b);
	}
	

	public List<Book> getBookList() {
		// TODO Auto-generated method stub
		return bookDao.getBookList();
	}


}