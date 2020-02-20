package com.itbulls.learnit.dao;

import java.util.List;

import com.itbulls.learnit.pojos.User;

public interface UserDao {
	User authenticateUser(String login, String password);

	List<User> getAllUsers();

	User getUserById(int id);

	boolean createUser(String username, String password, String mail, String birthday, int roleId);

	boolean deleteUser(int userId);

	boolean updateUser(int userId, String username, String password, String mail, String birthday, int roleId);

	User getUserByOrderId(int orderId);

	boolean updateUserPassword(int userId, String password);

	boolean updateUserBirthday(int userId, String birthday);

	boolean updateUserMail(int userId, String mail);

	boolean updateUserRole(int userId, int userRole);

	boolean updateUserName(int userId, String username);

}
