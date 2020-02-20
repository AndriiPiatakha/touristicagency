package com.itbulls.learnit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.dao.RentalDao;
import com.itbulls.learnit.pojos.Rental;
import com.itbulls.learnit.utilities.DateService;
import com.itbulls.learnit.utilities.db.ConnectionManager;

public class RentalDaoImpl implements RentalDao {
	private final static String CREATE_RENTAL = "INSERT INTO rentals (`name`, `description`, `from`, `to`, `price`, `city_id`, `city_name`, `rental_price`) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String DELETE_RENTAL = "DELETE FROM rentals WHERE rental_id = ?";
	private final static String UPDATE_RENTAL = "UPDATE `protraveldb`.`rental` SET `rental_id`= ?, `name`= ?, `description`= ?, `from`= ?, `to`= ?, `price`= ?, `city_id`= ?, `city_name`= ? `rental_price` = ? WHERE `rental_id`= ?;";

	private final static String SELECT_RENTAL_BY_ORDER_ID = "SELECT r.rental_id, r.name, r.description, r.from, r.to, r.price, r.city_id, r.city_name\r\n"
			+ "FROM orders o\r\n" + "INNER JOIN rentals r\r\n" + "WHERE o.rental_id = ?;";
	private static final String SELECT_RENTAL_BY_ID = "SELECT * FROM rental WHERE rental_id = ?;";
	private static final String SELECT_ALL_RENTALS = "SELECT * FROM rental;";
	private static final String SELECT_RENTAL_BY_CITY = "SELECT * FROM rental WHERE city_name = ?;";

	@Override
	public List<Rental> getRentalsByCityName(String cityName) {
		List<Rental> rentalsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_RENTAL_BY_CITY);
			ps.setString(1, cityName);
			rs = ps.executeQuery();
			while (rs.next()) {
				rentalsList.add(getRentalFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rentalsList;
	}

	@Override
	public List<Rental> getRentalsByOrderId(int orderId) {
		List<Rental> rentalsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_RENTAL_BY_ORDER_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				rentalsList.add(getRentalFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rentalsList;
	}

	@Override
	public Rental getRentalById(int rentalId) {
		Rental rental = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_RENTAL_BY_ID);
			ps.setInt(1, rentalId);
			rs = ps.executeQuery();
			while (rs.next()) {
				rental = getRentalFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rental;
	}

	@Override
	public List<Rental> getAllRentals() {
		List<Rental> rentalsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_RENTALS);
			rs = ps.executeQuery();
			while (rs.next()) {
				rentalsList.add(getRentalFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rentalsList;
	}

	@Override
	public boolean createRental(String name, String description, String fromDate, String toDate, int price, String city) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		java.sql.Date sqlFrom = DateService.toSqlDate(fromDate);
		java.sql.Date sqlTo = DateService.toSqlDate(toDate);

		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_RENTAL);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setDate(3, sqlFrom);
			ps.setDate(4, sqlTo);
			ps.setInt(5, price);
			ps.setString(6, city);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean updateRental(int rentalId, String name, String description, String fromDate, String toDate,
			int price, String city) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		java.sql.Date sqlFrom = DateService.toSqlDate(fromDate);
		java.sql.Date sqlTo = DateService.toSqlDate(toDate);

		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(UPDATE_RENTAL);
			ps.setInt(1, rentalId);
			ps.setString(2, name);
			ps.setString(3, description);
			ps.setDate(4, sqlFrom);
			ps.setDate(5, sqlTo);
			ps.setInt(6, price);
			ps.setString(7, city);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean deleteRental(int rentalId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_RENTAL);
			ps.setInt(1, rentalId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	// Utility methods
	private static Rental getRentalFromDb(ResultSet rs) throws SQLException {
		return new Rental(rs.getInt("rental_id"), rs.getString("name"), rs.getString("description"), rs.getInt("rental_price"), rs.getString("city_name"));

	}
}
