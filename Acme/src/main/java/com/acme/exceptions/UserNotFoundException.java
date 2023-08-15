package com.acme.exceptions;

public class UserNotFoundException extends Exception {

	/**
	 * @author Sonam AD35997
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}
	
	

}