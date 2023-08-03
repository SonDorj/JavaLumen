package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import com.bookapp.model.Book;

public class BookDetails {
	public static List<Book> showBooks(){
		return Arrays.asList(
				new Book("Java in Action", "John David", "Tech",1,900.90),
				new Book ("5 am club", "Robin Sharma", "Selfhelp", 2,300.68),
				new Book ("HTML for Dummies", "Ben John", "Tech", 3, 1900.45),
				new Book ("Secret Seven", "Enid Ben", "Fiction", 4,700.08), 
				new Book("Seven Habits", "John Hopper", "Selfhelp", 5,800.56)
				);
	}
}
