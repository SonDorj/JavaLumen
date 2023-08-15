package com.acme.service;

import java.util.List;

import com.acme.exceptions.UserNotFoundException;
import com.acme.model.User;


public interface IUserService extends AutoCloseable{
	public boolean addUser(User user);
	public boolean deleteUser(String username);
	public List<User> getAll() throws UserNotFoundException;
	public String checkUserExist(User user) throws UserNotFoundException;
	@Override
	void close();
}
