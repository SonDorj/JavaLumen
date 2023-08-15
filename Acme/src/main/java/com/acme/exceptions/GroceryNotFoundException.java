package com.acme.exceptions;

public class GroceryNotFoundException extends Exception {

	/**
	 * @author Sonam AD35997
	 */
	private static final long serialVersionUID = 1L;

	public GroceryNotFoundException() {
		super();
	}

	public GroceryNotFoundException(String message) {
		super(message);
	}
	
	

}