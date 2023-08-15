package com.acme.dao;

import java.util.List;

import com.acme.model.Grocery;

public interface IInventoryDao extends AutoCloseable{
	public int insertGrocery(Grocery grocery);
	public int updateGrocery(int groceryId, Grocery grocery);
	public int deleteGrocery(int groceryId);
	public int updateStock(int groceryId, int stock);
	public List<Grocery> fetchAll();
	public List<Grocery> fetchByName(String name);
	public Grocery fetchByID(int groceryId);
	@Override
	void close();
}
