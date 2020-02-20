package com.itbulls.learnit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.dao.BookingDao;
import com.itbulls.learnit.pojos.Booking;
import com.itbulls.learnit.utilities.DateService;
import com.itbulls.learnit.utilities.db.ConnectionManager;

public class BookingDaoImpl implements BookingDao {
	
	private final static String CREATE_BOOKING = "INSERT INTO orders_hotels (order_id, hotel_id, checkin, checkout, price, nights) VALUES(?, ?, ?, ?, ?, ?)";
	private final static String UPDATE_BOOKING = "UPDATE `protraveldb`.`orders_hotels` SET `order_id`= ?, `hotel_id`= ?, `checkin`= ?, `checkout`= ?, `price`= ?, `nights`= ? WHERE `booking_id`= ?;";

	private final static String DELETE_BOOKING = "DELETE FROM orders_hotels WHERE booking_id = ?";
	private final static String SELECT_BOOKING_BY_ID = "SELECT * FROM orders_hotels WHERE booking_id = ?";
	private final static String SELECT_BOOKING_BY_ORDER_ID = "SELECT * FROM orders_hotels WHERE order_id = ?";

	private final static String SELECT_ALL_BOOKINGS = "SELECT * FROM orders_hotels";
	
	@Override
	public Booking getBookingById(int bookingId) {
		Booking booking = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_BOOKING_BY_ID);
			ps.setInt(1, bookingId);
			rs = ps.executeQuery();
			while (rs.next()) {
				booking = getBookingFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return booking;
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> bookingsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_BOOKINGS);
			rs = ps.executeQuery();
			while (rs.next()) {
				bookingsList.add(getBookingFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return bookingsList;
	}

	@Override
	public List<Booking> getBookingByOrderId(int orderId) {
		List<Booking> bookingsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_BOOKING_BY_ORDER_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				bookingsList.add(getBookingFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return bookingsList;
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_BOOKING);
			ps.setInt(1, bookingId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean createBooking(int orderId, int hotelId, String checkin, String checkout, int price, int nights) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_BOOKING);
			ps.setInt(1, orderId);
			ps.setInt(2, hotelId);
			System.out.println(checkin);
			ps.setDate(3, DateService.toSqlDate(checkin));
			ps.setDate(4, DateService.toSqlDate(checkout));
			ps.setInt(5, price);
			ps.setInt(6, nights);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean updateBooking(int bookingId, int orderId, int hotelId, String checkin, String checkout, int price, int nights) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(UPDATE_BOOKING);
			ps.setInt(1, orderId);
			ps.setInt(2, hotelId);
			ps.setDate(3, DateService.toSqlDate(checkin));
			ps.setDate(4, DateService.toSqlDate(checkout));
			ps.setInt(5, price);
			ps.setInt(6, nights);
			ps.setInt(7, bookingId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}
	// Utility methods
	private static Booking getBookingFromDb(ResultSet rs) throws SQLException {
		return new Booking(rs.getInt("booking_id"), rs.getInt("order_id"), rs.getInt("hotel_id"), rs.getDate("checkin")
				, rs.getDate("checkout"), rs.getInt("price"), rs.getInt("nights"));
	}
}
