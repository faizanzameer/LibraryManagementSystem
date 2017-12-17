package com.lms.service;

import com.lms.bean.Book;

public interface IBookService {
	void addBook(Book book);
	boolean isBookAvailable(Book book);
	Book getBookByTitle(String title);
	void markBookAsBorrowed(Book book);
}
