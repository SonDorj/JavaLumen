package com.acme.util;

public class Query{
	private Query() {
		throw new IllegalStateException("Can't instantiate Utility class");
	}
	public static final String CREATE = " create table if not exists inventory"
			+ "(groceryId int primary key auto_increment," + " name varchar(30) not null,"
			+ " price double not null," + " stock int not null," + " constraint chk_stock CHECK(stock>=0),"
			+ " constraint unq_all unique(name,price));";

	public static final String RESETAUTO = "alter table inventory auto_increment = 1;";

	public static final String INSERT = "insert into inventory(name,price,stock) values(?,?,?);";

	public static final String UPDATE = "update inventory set name=?, price=?,stock=? where groceryId=?;";

	public static final String DELETE = "delete from inventory where groceryId=?;";

	public static final String SELECTALL = "select * from inventory order by groceryId;";
	
	public static final String SELECTITEM = "select groceryId,stock from inventory where name=? and price=?;";
	
	public static final String SELECTBYID= "select * from inventory where groceryId=?;";
	
	public static final String SELECTBYNAME= "select * from inventory where name like ?;";
	
	public static final String UPDATESTOCK = "update inventory set stock=? where groceryId=?;";
}
