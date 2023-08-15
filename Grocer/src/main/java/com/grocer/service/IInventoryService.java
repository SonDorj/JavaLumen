package com.grocer.service;

import java.sql.SQLException;
import java.util.Map;
import com.grocer.exception.GroceryNotFoundException;
import com.grocer.exception.StockLimitExceededException;
import com.grocer.model.Grocery;

public interface IInventoryService extends AutoCloseable {
	public boolean addGrocery(Grocery grocery) throws Exception;
	public boolean updateGrocery(int groceryId, Grocery grocery) throws SQLException;
	public boolean deleteGrocery(int groceryId) throws SQLException;
	public boolean updateStock(int groceryId, int stock) throws SQLException, GroceryNotFoundException, StockLimitExceededException;
	public Map<Integer, Grocery> fetchAll() throws SQLException;
	public Grocery fetchByID(int groceryId) throws SQLException;
	@Override
	void close();
}
