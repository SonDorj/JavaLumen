package com.grocer.util;

public class QueryInventory {
	public static final String CREATE = " create table if not exists inventory"
			+ "(groceryId int primary key auto_increment," + " grocery varchar(30) not null,"
			+ " price double not null," + " stock int not null," + " constraint chk_stock CHECK(stock>=0),"
			+ " constraint unq_all unique(grocery,price));";

	public static final String RESETAUTO = "alter table inventory auto_increment = 1;";

	public static final String INSERT = "insert into inventory(grocery,price,stock) values(?,?,?);";

	public static final String UPDATE = "update inventory set grocery=?, price=?,stock=? where groceryId=?;";

	public static final String DELETE = "delete from inventory where groceryId=?;";

	public static final String SELECTALL = "select * from inventory order by groceryId;";
	
	public static final String SELECTBYID= "select * from inventory where groceryId=?;";
	
	public static final String UPDATESTOCK = "update inventory set stock=? where groceryId=?;";
}
