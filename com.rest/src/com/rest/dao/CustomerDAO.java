package com.rest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import com.rest.daoHelper.CustomerDAOHelper;
import com.rest.model.CustomerVO;
import com.rest.sql.CustomerSQL;

public class CustomerDAO extends BaseConnectionDAO {

	// used for user email Validation during signup
	public CustomerVO emailCheck(CustomerVO user) {
		CustomerVO userObj = null;
		try {
			String sql = CustomerSQL.usedEmailsql;
			PreparedStatement statement = getFinalConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			userObj = new CustomerVO();
			while (rs.next()) {
				if (user.getEmail().equalsIgnoreCase(rs.getString(1))) {
					throw new Exception("You are an already registered");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return userObj;
	}

	// used for user userId Validation during signup
	public CustomerVO userIdCheck(CustomerVO user) {
		CustomerVO userObj = null;
		try {
			String sql = CustomerSQL.usedUserIdsql;
			PreparedStatement statement = getFinalConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			userObj = new CustomerVO();
			while (rs.next()) {
				if (user.getUserId().equalsIgnoreCase(rs.getString(1))) {
					throw new Exception("This userID has already been used. Please give a new userId");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return userObj;
	}

	// used to create new user
	public void createNewUser(CustomerVO user) {
		try {
			String sql = CustomerSQL.signUpSQL;
			PreparedStatement statement = getFinalConnection().prepareStatement(sql);
			CustomerDAOHelper custDaoHelper = new CustomerDAOHelper();
			
			// generate next Customer ObjectId
			statement.setString(1, custDaoHelper.getNextUserId());
			statement.setString(2, user.getNameFirst());
			statement.setString(3, user.getNameMiddle());
			statement.setString(4, user.getNameLast());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getUserId());
			statement.setString(7, user.getPassword());
			statement.setTimestamp(8, new Timestamp(new Date().getTime()));
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// used for User Authentication during Login
	public CustomerVO checkCustomer(CustomerVO user) {
		CustomerVO userObj = null;
		try {
			String sql = CustomerSQL.validLoginSQL;
			PreparedStatement statement = getFinalConnection().prepareStatement(sql);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getUserId());
			statement.setString(3, user.getPassword());

			ResultSet rs = statement.executeQuery();
			userObj = new CustomerVO();
			if (rs.next()) {
				userObj.setObjectId(rs.getString(1));
				updateLastLogin(userObj);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return userObj;
	}
	
	//used to update LastLogin
	private void updateLastLogin(CustomerVO userObj) {
		try {
			String sql = CustomerSQL.updateLastLogin;
			PreparedStatement statement = getFinalConnection().prepareStatement(sql);
			statement.setTimestamp(1, new Timestamp(new Date().getTime()));
			statement.setString(2, userObj.getObjectId());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
