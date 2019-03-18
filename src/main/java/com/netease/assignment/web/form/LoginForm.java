package com.netease.assignment.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotNull
	@Size(min = 5, max = 10)
	private String username;

	@NotNull
	@Size(min = 32, max = 32)
	private String password;

	private boolean autoLogin = false;

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public boolean isAutoLogin() {

		return autoLogin;
	}

	public void setAutoLogin(boolean autoLogin) {

		this.autoLogin = autoLogin;
	}

}
