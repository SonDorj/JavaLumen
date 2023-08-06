package com.bookapp.util;

public class Queries {
	public static final String CREATEQUERY = "create table if not exists books(bookId int primary key,"
			+ "title varchar(40) not null, author varchar(20) not null, genre varchar(20), price double);";
	public static final String INSERTQUERY = "insert into books(bookId,title,author,genre,price) values(?,?,?,?,?);";
	public static final String UPDATEPRICEQUERY = "update books set price=? where bookId =?;";
	public static final String DELETEQUERY = "delete from books where bookId=?;";

	public static final String QUERYALL = "select * from books;";
	public static final String QUERYBYBOOKID = "select * from books where bookId=?;";
	public static final String QUERYBYAUTHOR = "select * from books where author like CONCAT( '%',?,'%');";
	public static final String QUERYBYGENRE = "select * from books where genre=CONCAT(?);";
	public static final String QUERYBYAUTHORANDGENRE = "select * from books where author like CONCAT( '%',?,'%') and genre=CONCAT(?);";
	public static final String QUERYBYPRICELESSTHAN = "select * from books where price<?;";
}
