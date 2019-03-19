package com.example.assignment.meta;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {

	private static final long serialVersionUID = -8074971779845361589L;

	private Integer userId;
	private String userName;
	private String password;

	private String userType;

	private boolean online;

	public User() {

		this.setOnline(false);
	}

	public Integer getUserId() {

		return userId;
	}

	public void setUserId(Integer userId) {

		this.userId = userId;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.setOnline(true);
		this.userName = userName;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getUserType() {

		return userType;
	}

	public void setUserType(String userType) {

		this.userType = userType;
	}

	public static long getSerialversionuid() {

		return serialVersionUID;
	}

	@Override
	public int compareTo(User o) {

		return Integer.valueOf(this.userId)
				.compareTo(Integer.valueOf(o.userId));
	}

	public void invalidate() {

		this.userName = null;
		this.password = null;
		this.userId = -1;
		this.setOnline(false);
	}

	public boolean isOnline() {

		return online;
	}

	public void setOnline(boolean online) {

		this.online = online;
	}

}
