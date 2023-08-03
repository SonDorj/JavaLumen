package com.bookapp.client;

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
		String category;
		int bookId;
		double price;
		
		
		System.out.println("Welcome to the Online libary");
		try (Scanner scanner = new Scanner(System.in);)
			{
			while(true) {	
				System.out.print("choices \n1.press one to list all books\n2.press two to add book\n3.press three to surf the library\n4.press four to exit\nChoice : ");
				mainMenu=scanner.nextLine();
				switch(mainMenu) {
				case "1": List<Book> books = bookService.getAll(); System.out.println("\nBooks in the Library"); for(Book book : books) System.out.println(book); break;
				case "2": 
					System.out.println("Enter Book Details");
					System.out.print("Title: "); title=scanner.nextLine();
					System.out.print("Author: "); author=scanner.nextLine();
					System.out.print("Category: "); category=scanner.nextLine();
					System.out.print("BookId: "); bookId=scanner.nextInt();
					System.out.print("Price: "); price=scanner.nextDouble();
					bookService.addBook(new Book(title,author,category,bookId,price));
					break;
				case "3": 
					System.out.println("Choices:");
					System.out.print("\n1.press one to surf for books by authors\n2.press two to surf books by category\n3.press three to surf book by author and category\n4.press four to surf book by bookId\n5.press five to surf book by price\n6.press six to exit");
					subMenu=scanner.nextLine();
					switch(subMenu) {
					case "1":	System.out.println("Enter the author: "); author=scanner.nextLine(); 
							bookService.getByAuthorContains(author).forEach(System.out::println);;
						break;
					case "2":	System.out.println("Enter the category: "); category=scanner.nextLine();
							bookService.getByCategory(category).forEach(System.out::println);
						break;
					case "3":	System.out.println("enter author: "); author=scanner.nextLine(); 
								System.out.println("Enter the category: "); category=scanner.nextLine();
							bookService.getByAuthorContainsAndCategory(author, category).forEach(System.out::println);;
						break;
					case "4":	System.out.println("enter the Id: "); bookId = scanner.nextInt();
							System.out.println(bookService.getById(bookId));
						break;
					case "5":	System.out.println("enter the price: "); price = scanner.nextDouble();
							bookService.getByPriceLessThan(price).forEach(System.out::println);;
						break;
					case "6":	System.exit(0);
					default:	System.out.println("enter valid choice");
					}
				case "4": System.exit(0);
				default : System.out.println("enter valid choice");
				}
			}
		} catch (BookNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
