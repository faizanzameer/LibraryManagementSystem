package com.lms.service.impl;

import com.lms.bean.Book;
import com.lms.dao.IBookDao;
import com.lms.dao.impl.BookDaoImpl;
import com.lms.service.IBookService;

public class BookServiceImpl implements IBookService {
	
	private IBookDao bookDao;
	
	public BookServiceImpl() {
		bookDao = new BookDaoImpl(); 
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public boolean isBookAvailable(Book book) {
		Book bookInDb = bookDao.getBookById(book.getId());
		if(null != bookInDb) {
			if(bookInDb.getAvailableCopies() > 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Book getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}
}
