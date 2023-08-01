package com.voterapp.exception;

public class NoVoterIDException extends InValidVoterException {

	public NoVoterIDException() {
		super();
	}

	public NoVoterIDException(String message) {
		super(message);
	}
	
}
