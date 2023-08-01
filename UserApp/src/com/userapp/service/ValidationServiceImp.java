package com.userapp.service;

import com.userapp.exception.NameExistException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public class ValidationServiceImp implements IValidationService {
	String[] userNames;
	
	public ValidationServiceImp(String[] userNames) {
		this.userNames = userNames;
	}

	@Override
	public boolean validateUserName(String username) throws NameExistException {
		for(String userName : userNames) {
			if(userName.equals(username))
				throw new NameExistException("User Already Registered");
		}
		return true;
	}

	@Override
	public boolean validatePassword(String password) throws TooLongException, TooShortException {
		int length = password.length();
		if(length<6)
			throw new TooShortException("Password length should be more than 6");
		else if(length>15)
			throw new TooLongException("Password length should be less than 15");
		else
			return true;
	}

}
