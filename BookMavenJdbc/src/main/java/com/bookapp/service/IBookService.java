package com.bookapp.service;

import java.sql.SQLException;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	void addBook(Book book) throws SQLException;

	void updateBookPrice(int bookId, double price) throws SQLException;

	void deleteBook(int bookId) throws SQLException;

	List<Book> getAll() throws BookNotFoundException, SQLException;

	List<Book> getByAuthorContains(String author) throws BookNotFoundException, SQLException;

	List<Book> getByGenre(String genre) throws BookNotFoundException, SQLException;

	List<Book> getByPriceLessThan(double price) throws BookNotFoundException, SQLException;

	List<Book> getByAuthorContainsAndGenre(String author, String genre) throws BookNotFoundException, SQLException;

	Book getByBookId(int bookId) throws BookNotFoundException, SQLException;
}
