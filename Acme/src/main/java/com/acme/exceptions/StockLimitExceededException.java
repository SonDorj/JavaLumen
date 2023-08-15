package com.acme.exceptions;

public class StockLimitExceededException extends Exception {

	/**
	 * @author Sonam AD35997
	 */
	private static final long serialVersionUID = 1L;

	public StockLimitExceededException() {
		super();
	}

	public StockLimitExceededException(String message) {
		super(message);
	}
	
	

}