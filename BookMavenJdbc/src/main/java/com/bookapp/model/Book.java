package com.bookapp.model;

public class Book {
	private String title;
	private String author;
	private String genre;
	private Integer bookId;
	private double price;

	public Book() {
		super();
	}

	public Book(Integer bookId, String title, String author, String genre, double price) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.bookId = bookId;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  bookId + ":\t" + title + "," + author + "," + genre + "," + "," + price;
	}

}
