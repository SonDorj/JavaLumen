package com.acme.service;

import java.util.List;

import com.acme.dao.IUserDao;
import com.acme.dao.UserDaoImpl;
import com.acme.exceptions.UserNotFoundException;
import com.acme.model.User;

public class UserServiceImpl implements IUserService {

	@Override
	public boolean addUser(User user) {
		try(IUserDao iUserDao= new UserDaoImpl();){
			int result = iUserDao.insertUser(user);
			return result > 0;
		}
	}

	@Override
	public boolean deleteUser(String username) {
		try(IUserDao iUserDao= new UserDaoImpl();){
			int result = iUserDao.deleteUser(username);
			return result > 0;
		}
	}

	@Override
	public List<User> getAll() throws UserNotFoundException {
		try(IUserDao iUserDao= new UserDaoImpl();){
			List<User> users = iUserDao.fetchAll();
			if(users.isEmpty())
				throw new UserNotFoundException();
			return users.stream().sorted((User o1, User o2)->o1.getUsername().compareTo(o2.getUsername())).toList();
		}
	}

	@Override
	public String checkUserExist(User user) throws UserNotFoundException {
		try(IUserDao iUserDao= new UserDaoImpl();){
			String userType= iUserDao.checkUserExist(user);
			if(userType==null)
				throw new UserNotFoundException();
			return userType;
		}
	}

	@Override
	public void close() {
		// closing statement

	}

}
