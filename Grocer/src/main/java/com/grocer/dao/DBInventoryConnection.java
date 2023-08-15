package com.grocer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.grocer.util.QueryInventory;

public class DBInventoryConnection {
	private static Connection connection=null;
	public static Connection openConnection() throws SQLException {
		//connection properties
		String url = "jdbc:mysql://localhost:3306/acme";
		String user = "root";
		String password = "admin@123";

		connection = DriverManager.getConnection(url,user,password);
		if(connection!=null) {
			Statement statement = connection.createStatement();
			statement.execute(QueryInventory.CREATE);
			return connection;
		}
		throw new SQLException("connection not succesfull");
	}
	public static void closeConnection() throws SQLException{
		if(connection!=null) {
			connection.close();
		}
	}
}
