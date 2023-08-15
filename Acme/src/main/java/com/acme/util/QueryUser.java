package com.acme.util;

public class QueryUser{
	private QueryUser() {
		throw new IllegalStateException("Can't instantiate Utility class");
	}
	public static final String CREATE = "create table if not exists user"
			+ "(userId int primary key auto_increment,"
			+ " username varchar(30) not null unique, password varchar(30) not null,"
			+ " type varchar(6) not null);";

	public static final String ADDADMIN = "insert into user(username,password,type)"
			+ " values('Admin','Admin@123','Admin')";
	public static final String CHECKADMIN= "select type from user where username='Admin' and password='Admin@123'";
	
	public static final String RESETAUTO = "alter table user auto_increment = 1;";

	public static final String INSERT = "insert into user(username,password,type) values(?,?,'client');";

	public static final String DELETE = "delete from user where username=?;";

	public static final String SELECTALL = "select * from user order by type, userId;";
	
	public static final String CHECK= "select type from user where username=? and password=?;";
	
	
}
