package com.bookapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookDao {
	void addBook(Book book) throws SQLException;

	void updateBookPrice(int bookId, double price) throws SQLException;

	void deleteBook(int bookId) throws SQLException;

	List<Book> findAll() throws SQLException;

	List<Book> findByAuthorContains(String author) throws BookNotFoundException, SQLException;

	List<Book> findByGenre(String category) throws BookNotFoundException, SQLException;

	List<Book> findByPriceLessThan(double price) throws BookNotFoundException, SQLException;

	List<Book> findByAuthorContainsAndGenre(String author, String category) throws BookNotFoundException, SQLException;

	Book findById(int bookId) throws BookNotFoundException, SQLException;
}
