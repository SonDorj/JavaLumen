package com.acme.service;

import java.util.List;

import com.acme.exceptions.GroceryNotFoundException;
import com.acme.exceptions.NegativeStockException;
import com.acme.exceptions.StockLimitExceededException;
import com.acme.model.Grocery;


public interface IInventoryService extends AutoCloseable{
	public boolean addGrocery(Grocery grocery);
	public boolean updateGrocery(int groceryId, Grocery grocery) throws GroceryNotFoundException;
	public boolean deleteGrocery(int groceryId) throws GroceryNotFoundException;
	public boolean sellGrocery(int groceryId, int stock) throws GroceryNotFoundException, StockLimitExceededException, NegativeStockException;
	public List<Grocery> getAll() throws GroceryNotFoundException;
	public Grocery getByID(int groceryId) throws GroceryNotFoundException;
	public List<Grocery> getByName(String name) throws GroceryNotFoundException;
	@Override
	void close();
}
