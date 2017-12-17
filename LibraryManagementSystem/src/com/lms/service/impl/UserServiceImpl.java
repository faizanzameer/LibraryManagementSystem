package com.lms.service.impl;

import java.util.List;

import com.lms.bean.Book;
import com.lms.bean.User;
import com.lms.dao.IUserDao;
import com.lms.dao.impl.UserDaoImpl;
import com.lms.service.IUserService;
import com.lms.util.dbutil.BookStore;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl(); 
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public int getNumOfBooksUserCanBorrow(User user) {
		User userInDb = userDao.getUserById(user.getId());
		if(null != userInDb) {
			List<Book> booksBorrowed = userInDb.getBooksBorrowed();
			if(null == booksBorrowed || booksBorrowed.size() < BookStore.MAX_BOOKS_BORROWED_COUNT) {
				return  BookStore.MAX_BOOKS_BORROWED_COUNT - booksBorrowed.size();
			}
		}
		return  0;
	}

}
