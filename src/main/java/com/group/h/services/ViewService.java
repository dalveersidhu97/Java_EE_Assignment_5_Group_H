package com.group.h.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class ViewService {
	@Autowired
	UserService userService;
	public String layoutContainer;
	private List<String> viewList = new ArrayList<String>();

	public String getLayoutContainer() {
		return layoutContainer;
	}

	public void setLayoutContainer(String layoutContainer) {
		this.layoutContainer = layoutContainer;
	}
	
	public String views(List<String> views) {
		clear();
		ListIterator<String> i = views.listIterator();
		// add .jsp after each view of views
		while(i.hasNext()) {
			viewList.add(i.next()+".jsp");
		}
		return layoutContainer;
	}
	
	public String view(String view) {
		clear();
		// add .jsp after view
		viewList.add(view+".jsp");
		return layoutContainer;
	}

	public ViewService clear() {
		viewList.clear();
		return this;
	}
	
	public ViewService model(Model m) {
		m.addAttribute("viewList", viewList);
		return this;
	}
	
	public ViewService model(Model m, HttpServletRequest request) {
		m.addAttribute("viewList", viewList);
		m.addAttribute("user", userService.isLoggedIn(request));
		return this;
	}
	
}
