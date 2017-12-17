package com.lms.service;

import com.lms.bean.User;

public interface IUserService {
	void addUser(User user);
	public int getNumOfBooksUserCanBorrow(User user);
}
