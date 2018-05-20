package com.rest.sql;

public class CustomerSQL {

	public static final String usedEmailsql = "select email from user_details";
	public static final String usedUserIdsql = "select userId from user_details";
	public static final String signUpSQL = "insert into user_details (objectId,first_name,middle_name,last_name,email,userId,password,signup_date) values (?, ?, ?, ?, ?, ?, ?,?)";
	public static final String validLoginSQL = "select * from user_details where email=? or userId=? and password=?";
	public static final String getLastObjectId = "select objectId FROM user_details ORDER BY objectId DESC LIMIT 1";
	public static final String updateLastLogin= "update user_details set lastLogin_date = ? where objectId = ?";

}
