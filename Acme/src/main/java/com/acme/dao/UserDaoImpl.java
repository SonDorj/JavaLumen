package com.acme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.acme.model.User;
import com.acme.util.QueryUser;

public class UserDaoImpl implements IUserDao {

	@Override
	public int insertUser(User user) {
		try (Connection connection = DBConnection.openUserConnection();
				PreparedStatement statementInsert = connection.prepareStatement(QueryUser.INSERT);) {
			
			statementInsert.setString(1, user.getUsername());
			statementInsert.setString(2, user.getPassword());
			return statementInsert.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int deleteUser(String username) {
		try (Connection connection = DBConnection.openUserConnection();
				PreparedStatement statement = connection.prepareStatement(QueryUser.DELETE);
				PreparedStatement statement2 = connection.prepareStatement(QueryUser.RESETAUTO);) {

			int result = -1;
			statement.setString(1, username);
			result = statement.executeUpdate();
			if (result > 0)
				statement2.executeUpdate();
			return result;
		} catch (SQLException | ClassNotFoundException e) {
			return -1;
		}
	}

	@Override
	public List<User> fetchAll() {
		List<User> queryResult = new ArrayList<>();
		try (Connection connection = DBConnection.openUserConnection();
				PreparedStatement statement = connection.prepareStatement(QueryUser.SELECTALL);
				ResultSet result = statement.executeQuery();) {

			while (result.next()) {
				User user = new User();
				user.setUserId(result.getInt(1));
				user.setUsername(result.getString(2));
				user.setPassword(result.getString(3));
				user.setType(result.getString(4));
				queryResult.add(user);
			}
			return queryResult;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public String checkUserExist(User user) {
		try (Connection connection = DBConnection.openUserConnection();
				PreparedStatement statement = connection.prepareStatement(QueryUser.CHECK);) {
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return result.getString(1);
			}
			return null;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void close() {
		//closing statement
	}

}
