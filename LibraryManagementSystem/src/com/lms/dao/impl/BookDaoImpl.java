package com.lms.dao.impl;

import com.lms.bean.Book;
import com.lms.dao.IBookDao;
import com.lms.util.dbutil.BookStore;

public class BookDaoImpl implements IBookDao {
	
	@Override
	public void addBook(Book book) {
		BookStore.BOOKS.add(book);
	}
	
	@Override
	public Book getBookById(Long bookId) {
		Book book = new Book();
		book.setId(bookId);
		if(!BookStore.BOOKS.isEmpty()) {
			int BookIndex = BookStore.BOOKS.indexOf(book);
			if(BookIndex < 0) {
				throw new IllegalArgumentException("Book doesn't exist");
			}
			return BookStore.BOOKS.get(BookIndex);
		}
		return null;
	}

	@Override
	public Book getBookByTitle(String title) {
		if(null != title && title.equalsIgnoreCase("")) {
			if(!BookStore.BOOKS.isEmpty()) {
				for (Book book : BookStore.BOOKS) {
					if(book.getTitle() != null && book.getTitle().equalsIgnoreCase(title)) {
						return book;
					}
				}
			}
		}
		return null;
	}

}
