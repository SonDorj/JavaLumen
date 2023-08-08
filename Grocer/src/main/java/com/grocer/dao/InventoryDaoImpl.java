package com.grocer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.grocer.exception.GroceryNotFoundException;
import com.grocer.model.Grocery;
import com.grocer.util.Query;

public class InventoryDaoImpl implements IInventoryDao{

	@Override
	public int insertGrocery(Grocery grocery) throws SQLException {
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = connection.prepareStatement(Query.INSERT);
		statement.setString(1, grocery.getGrocery());
		statement.setDouble(2, grocery.getPrice());
		statement.setInt(3, grocery.getStock());
		return statement.executeUpdate();
	}

	@Override
	public int updateGrocery(int groceryId, Grocery grocery) throws SQLException {
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = connection.prepareStatement(Query.UPDATE);
		statement.setString(1, grocery.getGrocery());
		statement.setDouble(2, grocery.getPrice());
		statement.setInt(3, grocery.getStock());
		statement.setInt(4, groceryId);
		return statement.executeUpdate();
	}

	@Override
	public int deleteGrocery(int groceryId) throws SQLException {
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = connection.prepareStatement(Query.DELETE);
		statement.setInt(1, groceryId);
		return statement.executeUpdate();
	}

	@Override
	public Map<Integer, Grocery> fetchAll() throws SQLException, GroceryNotFoundException {
		Map<Integer,Grocery> queryResult = new HashMap<>();
		Connection connection = DBConnection.openConnection();
		PreparedStatement statement = connection.prepareStatement(Query.SELECTALL);
		ResultSet result = statement.executeQuery();
		if(!result.next())
			throw new GroceryNotFoundException("No Groceries in Inventory");
		while(result.next()) {
			Grocery grocery = new Grocery();
			grocery.setGrocery(result.getString(2));
			grocery.setPrice(result.getDouble(3));
			grocery.setStock(result.getInt(4));
			queryResult.put(result.getInt(1), grocery);
		}
		return queryResult;
	}

}
