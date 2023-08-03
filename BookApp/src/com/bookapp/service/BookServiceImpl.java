package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {
	List<Book> books = new ArrayList<>();

	public BookServiceImpl() {
		super();
		this.books = new ArrayList<>(BookDetails.showBooks());
	}

	@Override
	public void addBook(Book book) {
		this.books.add(book);
	}

	@Override
	public List<Book> getAll() {
		return books;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		for (Book book : this.books)
			if (book.getAuthor().toUpperCase().contains(author.toUpperCase()))
				bookByAuthor.add(book);
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book written by : " + author);
		return bookByAuthor;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		for (Book book : this.books)
			if (book.getCategory().equals(category))
				bookByAuthor.add(book);
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book found in : " + category);
		return bookByAuthor;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		for (Book book : this.books)
			if (((Double) book.getPrice()) < price)
				bookByAuthor.add(book);
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book at : " + price +" rupees");
		return bookByAuthor;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		for (Book book : this.books)
			if (book.getAuthor().equals(author) && book.getCategory().equals(category))
				bookByAuthor.add(book);
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book written by : " + author + " and in the category : " + category);
		return bookByAuthor;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		for (Book book : this.books)
			if (((Integer) book.getBookId()) == bookId)
				return book;
		throw new BookNotFoundException("The Book doesn't exist");
	}

}
