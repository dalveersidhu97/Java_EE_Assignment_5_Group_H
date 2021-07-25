package com.group.h.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.group.h.beans.Login;
import com.group.h.beans.User;
import com.group.h.dao.UserDao;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description This class interact with userDao bean to provide a layer of
 *              abstraction.
 * 
 */

interface UserServiceInterface {
	int register(User user);

	User validateUser(Login login);
}

public class UserService implements UserServiceInterface {
	@Autowired
	public UserDao userDao;


	public int register(User user) {

		//return userDao.register(user);
		return 0;
	}

	public User validateUser(Login login) {
		// encrypting to match with the encrypted password in database
		//login.setPassword(enService.encrypt(login.getPassword()));
		return userDao.validateUser(login);
	}

	// return User object if user is logged in otherwise returns null
	public User isLoggedIn(HttpServletRequest request) {
		String username = "", password="";
		
		if(request.getCookies() == null) return null;
		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("username"))
				username = cookie.getValue();
			if (cookie.getName().equals("token"))
				password = cookie.getValue();
		}
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		return userDao.validateUser(login);
	}

}