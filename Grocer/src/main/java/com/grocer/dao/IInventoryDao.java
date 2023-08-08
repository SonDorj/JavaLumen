package com.grocer.dao;

import java.sql.SQLException;
import java.util.Map;

import com.grocer.exception.GroceryNotFoundException;
import com.grocer.model.Grocery;

public interface IInventoryDao {
	public int insertGrocery(Grocery grocery) throws SQLException;
	public int updateGrocery(int groceryId, Grocery grocery) throws SQLException;
	public int deleteGrocery(int groceryId) throws SQLException;
	public Map<Integer, Grocery> fetchAll() throws SQLException, GroceryNotFoundException;
}
