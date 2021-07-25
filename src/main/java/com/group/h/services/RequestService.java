package com.group.h.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.h.beans.*;
import com.group.h.dao.*;

public class RequestService {
	@Autowired
	public RequestDao requestDao;

	public void issueBook(User u, Request b) {
		requestDao.issueBook(u, b);
	}

	public List<Request> getIssuedBookList() {
		return requestDao.getIssuedBookList();
	}


	public void returnBook(String bookId) {
		requestDao.returnBook(bookId);
		
	}

}