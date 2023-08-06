package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	void addBook(Book book);
	void updateBookPrice(int bookId, double price);
	void deleteBook(int bookId);
	
	List<Book> getAll();
	List<Book> getByAuthorContains(String author);
	List<Book> getByGenre(String genre);
	List<Book> getByPriceLessThan(double price);
	List<Book> getByAuthorContainsAndGenre(String author, String genre);
	Book getByBookId(int bookId);
}
