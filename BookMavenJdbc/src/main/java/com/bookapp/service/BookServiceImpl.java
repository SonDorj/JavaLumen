package com.bookapp.service;

import java.util.List;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {

	@Override
	public void addBook(Book book) {
		
	}

	@Override
	public List<Book> getAll() {
		return null;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		return null;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		return null;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		return null;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		return null;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		return null;
	}

	@Override
	public void updateBookPrice(int bookId, double price) {
		
	}

	@Override
	public void deleteBook(int bookId) {
		
	}
}
