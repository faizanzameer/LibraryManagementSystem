package com.lms.controller;

import com.lms.bean.User;
import com.lms.service.IUserService;
import com.lms.service.impl.UserServiceImpl;

public class UserController {
	
	private IUserService userService;
	
	public UserController() {
		this.userService = new UserServiceImpl();
	}
	
	public void addUser(User user) {
		userService.addUser(user);
	}

}
