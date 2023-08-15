package com.acme.service;

import java.util.List;

import com.acme.dao.IInventoryDao;
import com.acme.dao.InventoryDaoImpl;
import com.acme.exceptions.GroceryNotFoundException;
import com.acme.exceptions.NegativeStockException;
import com.acme.exceptions.StockLimitExceededException;
import com.acme.model.Grocery;

public class InventoryServiceImpl implements IInventoryService {

	@Override
	public void close(){
		//closing
	}

	@Override
	public boolean addGrocery(Grocery grocery) {
		try(IInventoryDao iInventoryDao= new InventoryDaoImpl();){
			int result = iInventoryDao.insertGrocery(grocery);
			return result > 0;
		}
	}

	@Override
	public boolean updateGrocery(int groceryId, Grocery grocery) throws GroceryNotFoundException {
		try(IInventoryDao iInventoryDao= new InventoryDaoImpl();){
			int result = iInventoryDao.updateGrocery(groceryId,grocery);
			return result > 0;
		}
	}

	@Override
	public boolean deleteGrocery(int groceryId) throws GroceryNotFoundException {
		try(IInventoryDao iInventoryDao= new InventoryDaoImpl();){
			int result = iInventoryDao.deleteGrocery(groceryId);
			return result > 0;
		}
	}

	@Override
	public boolean sellGrocery(int groceryId, int amount) throws GroceryNotFoundException, StockLimitExceededException, NegativeStockException {
		try(IInventoryDao iInventoryDao= new InventoryDaoImpl();){
			Grocery grocery = iInventoryDao.fetchByID(groceryId);
			if(grocery==null)
				throw new GroceryNotFoundException("No grocery with id: "+groceryId);
			if(grocery.getStock()<amount)
				throw new StockLimitExceededException("Not enough stocks of "+ grocery.getName());
			if(amount<0)
				throw new NegativeStockException("Amount can't be negative");
			int result = iInventoryDao.updateStock(groceryId, grocery.getStock() - amount);
			return result > 0;
		}
	}

	@Override
	public List<Grocery> getAll() throws GroceryNotFoundException {
		try(IInventoryDao iInventoryDao= new InventoryDaoImpl();){
			List<Grocery> groceries = iInventoryDao.fetchAll();
			if(groceries.isEmpty())
				throw new GroceryNotFoundException("No grocery in Inventory");
			return groceries.stream().sorted((Grocery o1,Grocery o2)->o1.getGroceryId().compareTo(o2.getGroceryId())).toList();
			
		}
	}

	@Override
	public Grocery getByID(int groceryId) throws GroceryNotFoundException {
		try(IInventoryDao iInventoryDao= new InventoryDaoImpl();){
			Grocery grocery = iInventoryDao.fetchByID(groceryId);
			if(grocery==null)
				throw new GroceryNotFoundException("No grocery with id: "+groceryId+" found");
			return grocery;
		}
	}
	
	@Override
	public List<Grocery> getByName(String name) throws GroceryNotFoundException {
		try(IInventoryDao iInventoryDao= new InventoryDaoImpl();){
			List<Grocery> groceries = iInventoryDao.fetchByName(name);
			if(groceries.isEmpty())
				throw new GroceryNotFoundException("No grocery with : "+name+" found");
			return groceries;
		}
	}
}
