package com.bookapp.service;

import java.sql.SQLException;
import java.util.List;

import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.IBookDao;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {
	IBookDao bookDao = new BookDaoImpl();

	@Override
	public void addBook(Book book) throws SQLException {
		bookDao.addBook(book);
	}

	@Override
	public List<Book> getAll() throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.findAll();
		if (books.isEmpty())
			throw new BookNotFoundException("No books by in the database");
		return books;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.findByAuthorContains(author);
		if (books.isEmpty()) {
			throw new BookNotFoundException("Book not found by " + author + " in author name");
		}
		return books;

	}

	@Override
	public List<Book> getByGenre(String genre) throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.findByGenre(genre);
		if (books.isEmpty()) {
			throw new BookNotFoundException("Book not found in " + genre);
		}
		return books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.findByPriceLessThan(price);
		if (books.isEmpty()) {
			throw new BookNotFoundException("Book not found for less than " + price + " rupees");
		}
		return books;
	}

	@Override
	public List<Book> getByAuthorContainsAndGenre(String author, String genre)
			throws BookNotFoundException, SQLException {
		List<Book> books = bookDao.findByAuthorContainsAndGenre(author, genre);
		if (books.isEmpty()) {
			throw new BookNotFoundException("Book not found in " + genre + " by " + author);
		}
		return books;
	}

	@Override
	public Book getByBookId(int bookId) throws BookNotFoundException, SQLException {
		Book book = bookDao.findById(bookId);
		if (book == null) {
			throw new BookNotFoundException("Book not found with id " + bookId);
		}
		return book;
	}

	@Override
	public void updateBookPrice(int bookId, double price) throws SQLException {
		bookDao.updateBookPrice(bookId, price);
	}

	@Override
	public void deleteBook(int bookId) throws SQLException {
		bookDao.deleteBook(bookId);
	}
}
