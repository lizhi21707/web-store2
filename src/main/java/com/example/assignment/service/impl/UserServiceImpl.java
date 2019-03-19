package com.example.assignment.service.impl;

import com.example.assignment.dao.IUserDao;
import com.example.assignment.meta.User;
import com.example.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User getUser(String userName) {

		User user = userDao.getUser(userName);

		return user;
	}

}
