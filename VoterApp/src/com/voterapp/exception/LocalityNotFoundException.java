package com.voterapp.exception;

import com.voterapp.exception.InValidVoterException;

public class LocalityNotFoundException extends InValidVoterException {

	public LocalityNotFoundException() {
		super();
	}

	public LocalityNotFoundException(String message) {
		super(message);
	}

}
