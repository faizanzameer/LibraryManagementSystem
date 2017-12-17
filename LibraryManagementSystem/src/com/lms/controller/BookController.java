package com.lms.controller;

import java.util.ArrayList;
import java.util.List;

import com.lms.bean.Book;
import com.lms.bean.User;
import com.lms.service.IBookService;
import com.lms.service.IUserService;
import com.lms.service.impl.BookServiceImpl;
import com.lms.service.impl.UserServiceImpl;
import com.lms.util.dbutil.BookStore;

public class BookController {
	
	private IBookService bookService;
	private IUserService userService;
	
	public BookController() {
		this.bookService = new BookServiceImpl();
		this.userService = new UserServiceImpl();
	}
	
	public void addBook(Book Book) {
		bookService.addBook(Book);
	}
	
	public void borrowBooks(List<Book> books, User user) {
		List<Book> booksBorrowed = user.getBooksBorrowed();
		if(null == booksBorrowed) {
			booksBorrowed = new ArrayList<>();
		}
		//1. Check if the user is eligible to borrow more books
		int numOfBooksUserCanBorrow = userService.getNumOfBooksUserCanBorrow(user);
		if(numOfBooksUserCanBorrow <=0 ) {
			throw new IllegalArgumentException("User has already exceeded the quota");
		}
		for (Book book : books) {
			// 2. Check if copies of desired book is available
			if(bookService.isBookAvailable(book) && numOfBooksUserCanBorrow <= BookStore.MAX_BOOKS_BORROWED_COUNT) {
				bookService.markBookAsBorrowed(book);
				booksBorrowed.add(book);
				numOfBooksUserCanBorrow--;
			}			
		}
		user.setBooksBorrowed(booksBorrowed);
	}
	
	public Book getBookByTitle(String title) {
		return bookService.getBookByTitle(title);
	}
	
	//NOTE: Return Book logic can be written similar to borrowBooks

}
