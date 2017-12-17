package com.lms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.lms.bean.User;
import com.lms.dao.IUserDao;
import com.lms.util.dbutil.UserStore;

public class UserDaoImpl implements IUserDao {
	
	@Override
	public void addUser(User user) {
		UserStore.USERS.add(user);
	}

	@Override
	public User getUserById(Long userId) {
		User user = new  User();
		user.setId(userId);
		if(!UserStore.USERS.isEmpty()) {
			int userIndex = UserStore.USERS.indexOf(user);
			if(userIndex < 0) {
				throw new IllegalArgumentException("User doesn't exist");
			}
			return UserStore.USERS.get(userIndex);
		}
		return null;
	}

	@Override
	public List<User> searchUsersByfirstName(String firstName) {
		List<User> users = new ArrayList<>();
		if(null != firstName && firstName.equalsIgnoreCase("")) {
			if(!UserStore.USERS.isEmpty()) {
				for (User user : UserStore.USERS) {
					if(user.getFirstName() != null && user.getFirstName().equalsIgnoreCase(firstName)) {
						users.add(user);
					}
				}
			}
		}
		return users;
	}

	@Override
	public List<User> searchUsersByLastName(String lastName) {
		List<User> users = new ArrayList<>();
		if(null != lastName && lastName.equalsIgnoreCase("")) {
			if(!UserStore.USERS.isEmpty()) {
				for (User user : UserStore.USERS) {
					if(user.getLastName() != null && user.getLastName().equalsIgnoreCase(lastName)) {
						users.add(user);
					}
				}
			}
		}
		return users;
	}

}
