package com.lms.dao;

import com.lms.bean.Book;

public interface IBookDao {
	void addBook(Book book);
	Book getBookById(Long bookId);
	Book getBookByTitle(String title);
}
