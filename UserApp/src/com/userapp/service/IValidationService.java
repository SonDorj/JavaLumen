package com.userapp.service;

import com.userapp.exception.NameExistException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;

public interface IValidationService {
	boolean validateUserName(String username) throws NameExistException;
	boolean validatePassword(String password) throws TooLongException, TooShortException;
}
