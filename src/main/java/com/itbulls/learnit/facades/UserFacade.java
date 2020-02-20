package com.itbulls.learnit.facades;

import java.util.List;

import com.itbulls.learnit.dao.impl.UserDaoImpl;
import com.itbulls.learnit.pojos.User;

public class UserFacade {
	UserDaoImpl uDao = new UserDaoImpl();
	
	public List<User> getUsers(){
		return uDao.getAllUsers();
	}
	public User getuserById(int id) {
		return uDao.getUserById(id);
	}
	public boolean createUser(String username, String mail, String password, String birthday, int role) {
		return uDao.createUser(username, mail, password, birthday, role);
	}
	public boolean updateUser(int userId, String username, String password, String mail, String birthday, int roleId) {
		return uDao.updateUser(userId, username, password, mail, birthday, roleId);
	}
	public boolean deleteUser(int userId) {
		return uDao.deleteUser(userId);
	}
	
	public boolean updateUserBirthday(int userId, String birthday) {
		return uDao.updateUserBirthday(userId, birthday);
	}

	public boolean updateUserMail(int userId, String mail) {
		return uDao.updateUserMail(userId, mail);
	}

	public boolean updateUserRole(int userId, int userRole) {
		return uDao.updateUserRole(userId, userRole);
	}

	public boolean updateUserName(int userId, String username) {
		return uDao.updateUserName(userId, username);
	}
	public boolean updateUserPassword(int userId, String password) {
		return uDao.updateUserPassword(userId, password);
	}
}
