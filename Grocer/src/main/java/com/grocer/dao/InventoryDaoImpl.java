package com.grocer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.grocer.model.Grocery;
import com.grocer.util.QueryInventory;

public class InventoryDaoImpl implements IInventoryDao {

	@Override
	public int insertGrocery(Grocery grocery) {
		try (Connection connection = DBInventoryConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(QueryInventory.INSERT);) {

			statement.setString(1, grocery.getGrocery());
			statement.setDouble(2, grocery.getPrice());
			statement.setInt(3, grocery.getStock());
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public int updateGrocery(int groceryId, Grocery grocery) {
		try (Connection connection = DBInventoryConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(QueryInventory.UPDATE);) {

			statement.setString(1, grocery.getGrocery());
			statement.setDouble(2, grocery.getPrice());
			statement.setInt(3, grocery.getStock());
			statement.setInt(4, groceryId);
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public int updateStock(int groceryId, int stock) {
		try (Connection connection = DBInventoryConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(QueryInventory.UPDATESTOCK);) {
			
			statement.setInt(1, stock);
			statement.setInt(2, groceryId);
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public int deleteGrocery(int groceryId) {
		try (Connection connection = DBInventoryConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(QueryInventory.DELETE);
				PreparedStatement statement2 = connection.prepareStatement(QueryInventory.RESETAUTO);) {

			int result = -1;
			statement.setInt(1, groceryId);
			result = statement.executeUpdate();
			if (result > 0)
				statement2.executeUpdate();
			return result;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public Map<Integer, Grocery> fetchAll() {
		Map<Integer, Grocery> queryResult = new HashMap<>();
		try (Connection connection = DBInventoryConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(QueryInventory.SELECTALL);
				ResultSet result = statement.executeQuery();) {
			
			while (result.next()) {
				Grocery grocery = new Grocery();
				grocery.setGrocery(result.getString(2));
				grocery.setPrice(result.getDouble(3));
				grocery.setStock(result.getInt(4));
				queryResult.put(result.getInt(1), grocery);
			}
			return queryResult;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Grocery fetchByID(int groceryId) {
		Grocery grocery = new Grocery();
		try (Connection connection = DBInventoryConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(QueryInventory.SELECTBYID);) {
			
			statement.setInt(1, groceryId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				grocery.setGrocery(result.getString(2));
				grocery.setPrice(result.getDouble(3));
				grocery.setStock(result.getInt(4));
			}
			return grocery;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void close() {

	}

}
