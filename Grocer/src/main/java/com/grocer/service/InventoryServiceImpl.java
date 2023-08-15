package com.grocer.service;

import java.sql.SQLException;
import java.util.Map;

import com.grocer.dao.IInventoryDao;
import com.grocer.dao.InventoryDaoImpl;
import com.grocer.exception.GroceryNotFoundException;
import com.grocer.exception.StockLimitExceededException;
import com.grocer.model.Grocery;

public class InventoryServiceImpl implements IInventoryService {

	@Override
	public void close() {
	}

	@Override
	public boolean addGrocery(Grocery grocery) throws SQLException {
		try(IInventoryDao inventoryDao = new InventoryDaoImpl();){
			
		}
		return false;
	}

	@Override
	public boolean updateGrocery(int groceryId, Grocery grocery) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGrocery(int groceryId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStock(int groceryId, int stock)
			throws SQLException, GroceryNotFoundException, StockLimitExceededException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, Grocery> fetchAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grocery fetchByID(int groceryId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
