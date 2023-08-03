package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {
	List<Book> books;

	public BookServiceImpl() {
		super();
		this.books = BookDetails.showBooks();
	}

	@Override
	public void addBook(Book book) {
		books.add(book);
	}

	@Override
	public List<Book> getAll() {
		return books;
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		bookByAuthor.addAll(0,this.books.stream().filter(book->book.getAuthor().toUpperCase().contains(author.toUpperCase())).collect(Collectors.toList()));
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book written by : " + author);
		return bookByAuthor;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		bookByAuthor.addAll(0,this.books.stream().filter(book->book.getCategory().toUpperCase().equals(category.toUpperCase())).collect(Collectors.toList()));
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book found in : " + category);
		return bookByAuthor;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		bookByAuthor.addAll(0,this.books.stream().filter(book->((Double)book.getPrice()<price)).collect(Collectors.toList()));
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book at : " + price +" rupees");
		return bookByAuthor;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> bookByAuthor = new ArrayList<>();
		bookByAuthor.addAll(0,this.books.stream().filter(book->(book.getCategory().toUpperCase().equals(category.toUpperCase()))&&(book.getAuthor().toUpperCase().contains(author.toUpperCase()))).collect(Collectors.toList()));
		if (bookByAuthor.size() == 0)
			throw new BookNotFoundException("No book written by : " + author + " and in the category : " + category);
		return bookByAuthor;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		return this.books.stream().filter(book->book.getBookId().equals(bookId)).findFirst().orElseThrow(()->new BookNotFoundException("The Book doesn't exist"));
	}

}
