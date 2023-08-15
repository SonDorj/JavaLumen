package com.acme.dao;

import java.util.List;

import com.acme.model.User;

public interface IUserDao extends AutoCloseable{
	public int insertUser(User user);
	public int deleteUser(String username);
	public List<User> fetchAll();
	public String checkUserExist(User user);
	@Override
	void close();
}
