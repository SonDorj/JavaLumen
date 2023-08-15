package com.grocer.model;

public class Grocery {
	private String grocery;
	private double price;
	private int stock;

	public Grocery() {
		super();
	}

	public Grocery(String grocery, Double price, Integer stock) {
		super();
		this.grocery = grocery;
		this.price = price;
		this.stock = stock;
	}

	public String getGrocery() {
		return grocery;
	}

	public void setGrocery(String grocery) {
		this.grocery = grocery;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Grocery [grocery=" + grocery + ", price=" + price + ", stock=" + stock + "]";
	}

}
