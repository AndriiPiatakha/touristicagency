package com.itbulls.learnit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.dao.TourDao;
import com.itbulls.learnit.pojos.Tour;
import com.itbulls.learnit.utilities.DateService;
import com.itbulls.learnit.utilities.db.ConnectionManager;

public class TourDaoImpl implements TourDao {
	private final static String CREATE_TOUR = "INSERT INTO tours (name, description, start, end, price, language) VALUES(?, ?, ?, ?, ?, ?)";
	private final static String DELETE_TOUR = "DELETE FROM tours WHERE tour_id = ? LIMIT 1";
	private final static String UPDATE_TOUR = "UPDATE tours SET name = ? , description = ?, start = ?, end = ?, price = ?, language = ? WHERE tour_id =?;";
	private final static String SELECT_TOUR_BY_ID = "SELECT * FROM tours WHERE tour_id = ?";
	private final static String SELECT_TOUR_BY_PERIOD = "SELECT * FROM tours WHERE start >= ? AND end <= ?";
	private final static String SELECT_ALL_TOURS = "SELECT * FROM tours";
	private final static String ORDER_TOUR = "INSERT INTO orders_tours (order_id, tour_id) VALUES(?, ?);";
	private final static String DELETE_ORDERED_TOUR = "DELETE FROM orders_tours WHERE order_id =?";

	@Override
	public Tour getTourById(int tourId) {
		Tour tour = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_TOUR_BY_ID);
			ps.setInt(1, tourId);
			rs = ps.executeQuery();
			while (rs.next()) {
				tour = getTourFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tour;
	}

	@Override
	public List<Tour> getAllTours() {
		List<Tour> tourList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_TOURS);
			rs = ps.executeQuery();
			while (rs.next()) {
				tourList.add(getTourFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tourList;
	}

	@Override
	public List<Tour> getToursByPeriod(String start, String end) {
		List<Tour> tourList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_TOUR_BY_PERIOD);
			ps.setDate(1, DateService.toSqlDate(start));
			ps.setDate(2, DateService.toSqlDate(end));
			System.out.println(DateService.toSqlDate(start));
			System.out.println(DateService.toSqlDate(end));
			rs = ps.executeQuery();
			while (rs.next()) {
				tourList.add(getTourFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return tourList;
	}

	@Override
	public boolean createTour(String name, String description, String start, String end, int price, String language) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		java.sql.Date sqlStartDate = DateService.toSqlDate(start);
		java.sql.Date sqlEndDate = DateService.toSqlDate(end);
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_TOUR);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setDate(3, sqlStartDate);
			ps.setDate(4, sqlEndDate);
			ps.setInt(5, price);
			ps.setString(6, language);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean updateTour(int tourId, String name, String description, String start, String end, int price,
			String language) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		java.sql.Date sqlStartDate = DateService.toSqlDate(start);
		java.sql.Date sqlEndDate = DateService.toSqlDate(end);
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(UPDATE_TOUR);
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setDate(3, sqlStartDate);
			ps.setDate(4, sqlEndDate);
			ps.setInt(5, price);
			ps.setString(6, language);
			ps.setInt(7, tourId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean deleteTour(int tourId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_TOUR);
			ps.setInt(1, tourId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean orderTour(int orderId, int tourId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(ORDER_TOUR);
			ps.setInt(1, orderId);
			ps.setInt(2, tourId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
	@Override
	public boolean deleteOrderedTour(int orderId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_ORDERED_TOUR);
			ps.setInt(1, orderId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	// Utility methods
	private static Tour getTourFromDb(ResultSet rs) throws SQLException {
		return new Tour(rs.getInt("tour_id"), rs.getString("name"), rs.getString("description"), rs.getDate("start"),
				rs.getDate("end"), rs.getInt("price"), rs.getString("language"));
	}
}
