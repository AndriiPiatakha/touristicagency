package com.itbulls.learnit.facades;

import com.itbulls.learnit.dao.impl.UserDaoImpl;
import com.itbulls.learnit.pojos.User;

public class LoginFacade {
	private UserDaoImpl user = new UserDaoImpl();

	public User authentificatedUser(String username, String password) {
		return user.authenticateUser(username, password);
	}
}
