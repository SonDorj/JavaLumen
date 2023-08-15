package com.acme.exceptions;

public class NegativeStockException extends Exception {

	/**
	 * @author Sonam AD35997
	 */
	private static final long serialVersionUID = 1L;

	public NegativeStockException() {
		super();
	}

	public NegativeStockException(String message) {
		super(message);
	}
	
	

}