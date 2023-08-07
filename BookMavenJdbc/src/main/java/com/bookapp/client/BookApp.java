package com.bookapp.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class BookApp {
	public static void main(String[] args) {
		IBookService bookService = new BookServiceImpl();
		String mainMenu;
		String subMenu;
		String title;
		String author;
		String genre;
		int bookId;
		double price;

		System.out.println("Welcome to the Online libary");
		try (Scanner scanner = new Scanner(System.in);) {
			while (true) {
				System.out.println("\nMenu");
				System.out.print(
						"1.List all books\n2.Add book\n3.Surf the library\n4.Update price\n5.Delete Book\n6.Exit\nChoice : ");
				mainMenu = scanner.nextLine();
				switch (mainMenu) {
				case "1":
					List<Book> books = new ArrayList<>();
					try {
						books = bookService.getAll();
						System.out.println("\nBooks in the Library");
						for (Book book : books)
							System.out.println(book);
					} catch (BookNotFoundException | SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "2":
					System.out.println("Enter Book Details");
					System.out.print("Title: ");
					title = scanner.nextLine();
					System.out.print("Author: ");
					author = scanner.nextLine();
					System.out.print("Category: ");
					genre = scanner.nextLine();
					System.out.print("BookId: ");
					bookId = scanner.nextInt();
					System.out.print("Price: ");
					price = scanner.nextDouble();
					scanner.nextLine();
					try {
						bookService.addBook(new Book(bookId, title, author, genre, price));
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "3":
					boolean flag = true;
					while (flag) {
						System.out.print(
								"\n1.Surf by authors\n2.Surf by genre\n3.Surf by price\n4.surf author and genre\n5.Surf by bookId\n6.Main menu");
						System.out.print("\nChoice: ");
						subMenu = scanner.nextLine();
						switch (subMenu) {
						case "1":
							System.out.print("Enter the author: ");
							author = scanner.nextLine();
							List<Book> booksByAuthor = new ArrayList<>();
							try {
								booksByAuthor = bookService.getByAuthorContains(author);
								if (booksByAuthor != null) {
									System.out.println("Books with author name containing " + author + " are: ");
									booksByAuthor.forEach(System.out::println);
								}
							} catch (BookNotFoundException | SQLException e) {
								System.out.println(e.getMessage());
							}
							break;
						case "2":
							System.out.print("Enter the genre: ");
							genre = scanner.nextLine();
							List<Book> booksByGenre;
							try {
								booksByGenre = bookService.getByGenre(genre);
								if (booksByGenre != null) {
									System.out.println("Books in " + genre + " are: ");
									booksByGenre.forEach(System.out::println);
								}
							} catch (BookNotFoundException | SQLException e) {
								System.out.println(e.getMessage());
							}
							break;
						case "3":
							System.out.print("Enter the price: ");
							price = scanner.nextDouble();
							scanner.nextLine();
							List<Book> booksByPrice;
							try {
								booksByPrice = bookService.getByPriceLessThan(price);
								if (booksByPrice != null) {
									System.out.println("Books with price less than " + price + " rupees: ");
									booksByPrice.forEach(System.out::println);
								}
							} catch (BookNotFoundException | SQLException e) {
								System.out.println(e.getMessage());
							}
							break;
						case "4":
							System.out.print("Enter the author: ");
							author = scanner.nextLine();
							System.out.print("Enter the genre: ");
							genre = scanner.nextLine();
							List<Book> booksByAuthorAndPrice;
							try {
								booksByAuthorAndPrice = bookService.getByAuthorContainsAndGenre(author, genre);
								if (booksByAuthorAndPrice != null) {
									System.out
											.println("Books written by author with " + author + " and genre " + genre);
									booksByAuthorAndPrice.forEach(System.out::println);
								}
							} catch (BookNotFoundException | SQLException e) {
								System.out.println(e.getMessage());
							}
							break;
						case "5":
							System.out.print("Enter the book Id: ");
							bookId = scanner.nextInt();
							scanner.nextLine();
							Book book;
							try {
								book = bookService.getByBookId(bookId);
								if (book != null) {
									System.out.println("Book with Id: " + bookId);
									System.out.println(book.toString());
								}
							} catch (BookNotFoundException | SQLException e) {
								System.out.println(e.getMessage());
							}
							break;
						case "6":
							flag = false;
							break;
						default:
							System.out.println("Enter valid choice: ");
						}
					}
					break;
				case "4":
					System.out.println("Enter the BookId: ");
					bookId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the new price: ");
					price = scanner.nextDouble();
					scanner.nextLine();
					try {
						bookService.updateBookPrice(bookId, price);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "5":
					System.out.println("Enter the BookId: ");
					bookId = scanner.nextInt();
					scanner.nextLine();
					try {
						bookService.deleteBook(bookId);
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "6":
					System.out.println("ThankYou...");
					System.exit(0);
				default:
					System.out.println("Enter valid choice");
				}
			}
		}
	}
}
