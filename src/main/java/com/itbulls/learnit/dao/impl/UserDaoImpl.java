package com.itbulls.learnit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.dao.UserDao;
import com.itbulls.learnit.pojos.User;
import com.itbulls.learnit.utilities.DateService;
import com.itbulls.learnit.utilities.PasswordService;
import com.itbulls.learnit.utilities.db.ConnectionManager;

public class UserDaoImpl implements UserDao {
	private final static String CREATE_USER = "INSERT INTO users(username, password, mail, birthday, role_id) VALUES(?, ?, ?, ?, ?)";
	private final static String DELETE_USER = "DELETE FROM users WHERE user_id = ?";
	private final static String UPDATE_USER = "UPDATE users SET username = ? , password = ?, mail = ?, birthday = ?, role_id = ? WHERE user_id =?;";
	private final static String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
	private final static String AUTHENTIFICATE_USER = "SELECT * FROM users WHERE username = ? AND password = ?";
	private final static String SELECT_ALL_USERS = "SELECT * FROM users";
	private final static String SELECT_USER_BY_ORDER_ID = "SELECT u.user_id, u.username, u.password, u.mail, u.birthday, u.role_id FROM orders o INNER JOIN users u WHERE o.user_id = ?;";
	
	
	private final static String CHANGE_NAME = "UPDATE users SET username = ? WHERE user_id =?;";
	private final static String CHANGE_ROLE = "UPDATE users SET username = ? WHERE user_id =?;";
	private final static String CHANGE_EMAIL = "UPDATE users SET mail = ? WHERE user_id =?;";
	private final static String CHANGE_BIRTHDAY = "UPDATE users SET birthday = ? WHERE user_id =?;";
	private final static String CHANGE_PASSWORD = "UPDATE users SET password = ? WHERE user_id =?;";

	
	
	@Override
	public User getUserById(int id) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = getUserFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_USERS);
			rs = ps.executeQuery();
			while (rs.next()) {
				userList.add(getUserFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userList;
	}

	@Override
	public User authenticateUser(String username, String password) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// encrypt the password to check against what's stored in DB
		String encryptedPass = PasswordService.encrypt(password);
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(AUTHENTIFICATE_USER);
			ps.setString(1, username);
			ps.setString(2, encryptedPass);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = getUserFromDb(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean createUser(String username, String mail, String password, String birthday, int roleId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		// encrypt the password to check against what's stored in DB
		String encryptedPass = PasswordService.encrypt(password);
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_USER);
			ps.setString(1, username);
			ps.setString(2, encryptedPass);
			ps.setString(3, mail);
			ps.setDate(4, DateService.toSqlDate(birthday));
			ps.setInt(5, roleId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean updateUser(int userId, String username, String password, String mail, String birthday, int roleId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		String encryptedPass = PasswordService.encrypt(password);
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(UPDATE_USER);
			ps.setString(1, username);
			ps.setString(2, encryptedPass);
			ps.setString(3, mail);
			ps.setDate(4, DateService.toSqlDate(birthday));
			ps.setInt(5, roleId);
			ps.setInt(6, userId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
	
	@Override
	public boolean updateUserName(int userId, String username) {
		return updateUserAttribute(userId, username, CHANGE_NAME);
	}
	@Override
	public boolean updateUserRole(int userId, int userRole) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CHANGE_ROLE);
			ps.setInt(1, userRole);
			ps.setInt(2, userId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
	
	@Override
	public boolean updateUserMail(int userId, String mail) {
		return updateUserAttribute(userId, mail, CHANGE_EMAIL);
	}
	
	@Override
	public boolean updateUserBirthday(int userId, String birthday) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CHANGE_BIRTHDAY);
			ps.setDate(1, DateService.toSqlDate(birthday));
			ps.setInt(2, userId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
	
	@Override
	public boolean updateUserPassword(int userId, String password) {
		String encryptedPass = PasswordService.encrypt(password);
		return updateUserAttribute(userId, encryptedPass, CHANGE_PASSWORD);
	}

	
	@Override
	public boolean deleteUser(int userId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_USER);
			ps.setInt(1, userId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
	
	
	@Override
	public User getUserByOrderId(int orderId) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_USER_BY_ORDER_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = getUserFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;
	}
	// Utility methods
	private static User getUserFromDb(ResultSet rs) throws SQLException {
		OrderDaoImpl oDao = new OrderDaoImpl();
		User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password").toCharArray(),
				rs.getString("mail"), rs.getDate("birthday"), rs.getInt("role_id"));
		user.setOrders(oDao.getOrdersByUserId(user.getId()));
		return user;
	}
	private boolean updateUserAttribute(int userId, String attribute, String statement) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(statement);
			ps.setString(1, attribute);
			ps.setInt(2, userId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
}
