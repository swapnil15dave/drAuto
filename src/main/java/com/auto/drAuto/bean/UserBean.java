package com.auto.drAuto.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBean {

	@Id
	private long userPhone;
	private String userName;
	private String userEmail;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "UserBean [userPhone=" + userPhone + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}

}
