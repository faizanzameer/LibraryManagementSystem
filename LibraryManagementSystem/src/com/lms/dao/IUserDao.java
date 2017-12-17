package com.lms.dao;

import java.util.List;

import com.lms.bean.User;

public interface IUserDao {
	void addUser(User user);
	User getUserById(Long userId);
	List<User> searchUsersByfirstName(String firstName);
	List<User> searchUsersByLastName(String lastName);
}
