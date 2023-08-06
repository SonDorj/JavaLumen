package com.bookapp.service;

import java.sql.SQLException;
import java.util.List;

import com.bookapp.dao.BookDaoImpl;
import com.bookapp.dao.DbConnection;
import com.bookapp.dao.IBookDao;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {
	IBookDao bookDao = new BookDaoImpl();

	@Override
	public void addBook(Book book) {
		try {
			bookDao.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}
	}

	@Override
	public List<Book> getAll() {
		try {
			return bookDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getByAuthorContains(String author){
		try {
			return bookDao.findByAuthorContains(author);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} return null;
	}

	@Override
	public List<Book> getByGenre(String genre) {
		try {
			return bookDao.findByGenre(genre);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} return null;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) {
		try {
			return bookDao.findByPriceLessThan(price);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} return null;
	}

	@Override
	public List<Book> getByAuthorContainsAndGenre(String author, String genre) {
		try {
			return bookDao.findByAuthorContainsAndGenre(author, genre);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} return null;
	}

	@Override
	public Book getByBookId(int bookId) {
		try {
			return bookDao.findById(bookId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} return null;
	}

	@Override
	public void updateBookPrice(int bookId, double price) {
		try {
			bookDao.updateBookPrice(bookId, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int bookId) {
		try {
			bookDao.deleteBook(bookId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
