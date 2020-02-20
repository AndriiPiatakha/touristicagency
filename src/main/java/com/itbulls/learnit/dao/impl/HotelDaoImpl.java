package com.itbulls.learnit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.dao.HotelDao;
import com.itbulls.learnit.pojos.Hotel;
import com.itbulls.learnit.utilities.db.ConnectionManager;

public class HotelDaoImpl implements HotelDao {
	private final static String CREATE_HOTEL = "INSERT INTO hotels (`name`, `address`, `suite_price, `city_id`, `city_name``) VALUES(?, ?, (SELECT city_id FROM cities WHERE city_name = ?), ?, ?)";
	private final static String DELETE_HOTEL = "DELETE FROM hotels WHERE hotel_id = ?";

	private final static String UPDATE_HOTEL = "UPDATE `protraveldb`.`hotels` SET `hotel_id`= ?, `name`= ?, `address`= ?, `suite_price`= ?, `city_id`= ?, `city_name`= ? WHERE `hotel_id`= ?;";
	private final static String SELECT_HOTEL_BY_ID = "SELECT * FROM hotels WHERE hotel_id = ?";
	private final static String SELECT_HOTELS_BY_CITY = "SELECT * FROM hotels WHERE city_name = ?;";
	private final static String SELECT_ALL_HOTELS = "SELECT * FROM hotels";
	private final static String SELECT_HOTEL_BY_ORDER_ID = "SELECT h.hotel_id, h.name, h.address, h.city_id, h.city_name\r\n"
			+ "FROM orders o\r\n" + "INNER JOIN hotels h\r\n" + "WHERE o.hotel_id = ?;";
	@Override
	public List<Hotel> getHotelsByOrderId(int orderId) {
		List<Hotel> hotelList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_HOTEL_BY_ORDER_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				hotelList.add(getHotelFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hotelList;
	}

	@Override
	public Hotel getHotelById(int hotelId) {
		Hotel hotel = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_HOTEL_BY_ID);
			ps.setInt(1, hotelId);
			rs = ps.executeQuery();
			while (rs.next()) {
				hotel = getHotelFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> hotelsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_HOTELS);
			rs = ps.executeQuery();
			while (rs.next()) {
				hotelsList.add(getHotelFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hotelsList;
	}

	@Override
	public List<Hotel> getHotelsByCity(String cityName) {
		List<Hotel> hotelsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_HOTELS_BY_CITY);
			ps.setString(1, cityName);
			rs = ps.executeQuery();
			while (rs.next()) {
				hotelsList.add(getHotelFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return hotelsList;
	}

	@Override
	public boolean createHotel(String name, String address, int suitePrice, String city) {
		PreparedStatement ps = null;
		int updatedRows = 0;

		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_HOTEL);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, suitePrice);
			ps.setString(4, city);
			

			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean updateHotel(int hotelId, String name, String address, int suitePrice, String city) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(UPDATE_HOTEL);
			ps.setInt(1, hotelId);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setInt(4, suitePrice);
			ps.setString(5, city);
			

			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_HOTEL);
			ps.setInt(1, hotelId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	// Utility methods
	private static Hotel getHotelFromDb(ResultSet rs) throws SQLException {
		return new Hotel(rs.getInt("hotel_id"), rs.getString("name"), rs.getString("address"),rs.getInt("suite_price"), rs.getString("city_name"));
	}
}
