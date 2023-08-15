package com.acme.model;

public class Grocery {
	
	private Integer groceryId;
	private String name;
	private double price;
	private int stock;

	public Grocery() {
		super();
	}

	public Grocery(String name, double price, int stock) {
		super();
		this.name = name;
		this.price = price;
		if(stock<0)
			throw new IllegalStateException();
		this.stock = stock;
	}

	public Grocery(Integer groceryId, String name, double price, int stock) {
		super();
		this.groceryId = groceryId;
		this.name = name;
		this.price = price;
		if(stock<0)
			throw new IllegalStateException();
		this.stock = stock;
	}

	public Integer getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(Integer groceryId) {
		this.groceryId = groceryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if(stock<0)
			throw new IllegalStateException();
		this.stock = stock;
	}
	
	public boolean isValid() {
		return name!=null && price!=0.0 && stock!=0;
	}

	@Override
	public String toString() {
		return "Grocery [groceryId=" + groceryId + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

}
