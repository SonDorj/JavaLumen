package com.acme.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.acme.util.Query;
import com.acme.util.QueryUser;

public final class DBConnection {
	private DBConnection() {
		throw new IllegalStateException("Can't instantiate Utility class");
	}

	private static Connection connection = null;
	private static Statement statement = null;
	

	public static Connection openConnection() throws SQLException, ClassNotFoundException {
		// connection properties	
		String url ="jdbc:mysql://localhost:3306/acme";
		String user ="root";
		String password ="admin@123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement();
		statement.execute(Query.CREATE);
		return connection;
	}
	public static Connection openUserConnection() throws SQLException, ClassNotFoundException {
		// connection properties	
		String url ="jdbc:mysql://localhost:3306/acme";
		String user ="root";
		String password ="admin@123";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement();
		try {
			ResultSet admin = statement.executeQuery(QueryUser.CHECKADMIN);
			if(admin.next()) {
				//do nothing
			}
			else {
				statement.execute(QueryUser.ADDADMIN);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}

		statement.execute(QueryUser.CREATE);
		return connection;
	}

	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if(statement != null) {
			statement.close();
		}
	}
}
