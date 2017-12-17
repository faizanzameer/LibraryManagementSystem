package com.lms.test;

import java.util.ArrayList;
import java.util.List;

import com.lms.bean.Author;
import com.lms.bean.Book;
import com.lms.bean.User;
import com.lms.controller.BookController;
import com.lms.controller.UserController;
import com.lms.util.dbutil.BookStore;
import com.lms.util.dbutil.UserStore;

public class LmsTester {

	public static void main(String[] args) {
		//1. Add User Test
		User user = getTestUser();
		UserController userController = new UserController();
		userController.addUser(user);
		
		//2. Add Test Book
		Book book = getTestBook();
		BookController bookController = new BookController();
		bookController.addBook(book);
		
		//3. Print Books
		System.out.println(BookStore.BOOKS);
				
		//4. Print Users
		System.out.println(UserStore.USERS);
		
		//5. User-1 borrows Book-1
		List<Book> books = new ArrayList<>();
		books.add(book);
		bookController.borrowBooks(books, user);
		
		//6. Print Books
		System.out.println(BookStore.BOOKS);
				
		//7. Print Users
		System.out.println(UserStore.USERS);
	}
	
	private static User getTestUser() {
		User user = new User();
		user.setId(1l);
		user.setFirstName("Test First Name");
		user.setLastName("Test Last Name");
		user.setEmail("Test email adddress");
		user.setPhoneNumber(123456789l);
		user.setAddress("Test address");
		user.setBooksBorrowed(new ArrayList<Book>());
		return user;
	}
	
	private static Book getTestBook() {
		Book book = new Book();
		book.setId(1);
		book.setTitle("Test Title");
		book.setDescription("Test Description");
		book.setAuthors(getTestAuthors());
		book.setTotalCopies(5);
		book.setIssuedCopies(2);
		book.setAvailableCopies(3);
		return book;
	}
	
	private static List<Author> getTestAuthors() {
		List<Author> authors = new ArrayList<>();
		Author author1 = new Author();
		author1.setId(1l);
		author1.setFirstName("Author-1 First Name");
		author1.setLastName("Author-1 Last Name");
		Author author2 = new Author();
		author2.setId(2l);
		author2.setFirstName("Author-2 First Name");
		author2.setLastName("Author-2 Last Name");
		authors.add(author1);
		authors.add(author2);
		return authors;
	}

}
