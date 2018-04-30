package com.rest.model;

import com.rest.controller.CustomerRestController;

public class CustomerVO {
	
	private String objectId;
	private String nameFirst;
	private String nameMiddle;
	private String nameLast;
	private String email;
	private String userId;
	private String password;
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	public String getNameMiddle() {
		return nameMiddle;
	}
	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
