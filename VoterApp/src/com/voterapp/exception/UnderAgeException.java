package com.voterapp.exception;

public class UnderAgeException extends InValidVoterException {

	public UnderAgeException() {
		super();
	}

	public UnderAgeException(String message) {
		super(message);
	}

}
