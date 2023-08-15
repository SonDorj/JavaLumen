package com.acme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.acme.model.Grocery;
import com.acme.util.Query;

public class InventoryDaoImpl implements IInventoryDao {

	@Override
	public int insertGrocery(Grocery grocery) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statementInsert = connection.prepareStatement(Query.INSERT);
				PreparedStatement statementCheck = connection.prepareStatement(Query.SELECTITEM);) {
			//add existing grocery by updating stock
			statementCheck.setString(1, grocery.getName());
			statementCheck.setDouble(2, grocery.getPrice());
			ResultSet result = statementCheck.executeQuery();
			if(result.next())
				return this.updateStock(result.getInt(1), result.getInt(2)+grocery.getStock());
			//add new grocery by updating stock
			else {
				statementInsert.setString(1, grocery.getName());
				statementInsert.setDouble(2, grocery.getPrice());
				statementInsert.setInt(3, grocery.getStock());
				return statementInsert.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int updateGrocery(int groceryId, Grocery grocery) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Query.UPDATE);) {

			statement.setString(1, grocery.getName());
			statement.setDouble(2, grocery.getPrice());
			statement.setInt(3, grocery.getStock());
			statement.setInt(4, groceryId);
			return statement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			return -1;
		}
	}

	@Override
	public int deleteGrocery(int groceryId) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Query.DELETE);
				PreparedStatement statement2 = connection.prepareStatement(Query.RESETAUTO);) {

			int result = -1;
			statement.setInt(1, groceryId);
			result = statement.executeUpdate();
			if (result > 0)
				statement2.executeUpdate();
			return result;
		} catch (SQLException | ClassNotFoundException e) {
			return -1;
		}
	}

	@Override
	public int updateStock(int groceryId, int stock) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Query.UPDATESTOCK);) {
			
			statement.setInt(1, stock);
			statement.setInt(2, groceryId);
			return statement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			return -1;
		}
	}

	@Override
	public List<Grocery> fetchAll() {
		List<Grocery> queryResult = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Query.SELECTALL);
				ResultSet result = statement.executeQuery();) {

			while (result.next()) {
				Grocery grocery = new Grocery();
				grocery.setGroceryId(result.getInt(1));
				grocery.setName(result.getString(2));
				grocery.setPrice(result.getDouble(3));
				grocery.setStock(result.getInt(4));
				queryResult.add(grocery);
			}
			return queryResult;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public Grocery fetchByID(int groceryId) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Query.SELECTBYID);) {
			
			Grocery grocery = new Grocery();
			statement.setInt(1, groceryId);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				grocery.setGroceryId(result.getInt(1));
				grocery.setName(result.getString(2));
				grocery.setPrice(result.getDouble(3));
				grocery.setStock(result.getInt(4));
			}
			if(grocery.isValid())
				return grocery;
			return null;
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}
	}
	@Override
	public List<Grocery> fetchByName(String name) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Query.SELECTBYNAME);) {
			
			List<Grocery> groceries = new ArrayList<>();
			statement.setString(1, "%"+name+"%");
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Grocery grocery = new Grocery();
				grocery.setGroceryId(result.getInt(1));
				grocery.setName(result.getString(2));
				grocery.setPrice(result.getDouble(3));
				grocery.setStock(result.getInt(4));
				groceries.add(grocery);
			}
			if(!groceries.isEmpty())
				return groceries;
			return Collections.emptyList();
		} catch (SQLException | ClassNotFoundException e) {
			return Collections.emptyList();
		}
	}

	@Override
	public void close() {
		//Closing 
 }

}
