package com.itbulls.learnit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.dao.FlightDao;
import com.itbulls.learnit.pojos.Flight;
import com.itbulls.learnit.utilities.DateService;
import com.itbulls.learnit.utilities.db.ConnectionManager;

public class FlightDaoImpl implements FlightDao {
	private final static String CREATE_FLIGHT = "INSERT INTO flights (`departure`, `from_city_id`, `from_city_name`, `to_city_id`, `to_city_name`, `flight_time`, `price`) "
			+ "VALUES(?, (SELECT city_id FROM cities WHERE city_name = ?) , ?, (SELECT city_id FROM cities WHERE city_name = ?), ?, ?, ?)";
	private final static String DELETE_FLIGHT = "DELETE FROM flights WHERE flight_id = ? LIMIT 1";
	private final static String UPDATE_FLIGHT = "SET `departure`= ?, `from_city_id`= (SELECT city_id FROM cities WHERE city_name = ?), `from_city_name`= ?, `to_city_id`= (SELECT city_id FROM cities WHERE city_name = ?), `to_city_name`= ?, `flight_time`= ?, `price`= ? WHERE `flight_id`=?;";
	private final static String SELECT_FLIGHT_BY_ID = "SELECT * FROM flights WHERE flight_id = ?";
	private final static String SELECT_ALL_FLIGHTS = "SELECT * FROM flights";
	private final static String SELECT_FLIGHT_BY_PERIOD = "SELECT * FROM flights WHERE departure >= ? AND departure <= ?";
	private final static String ORDER_FLIGHT = "INSERT INTO orders_flights (order_id, flight_id) VALUES(?, ?);";
	private final static String DELETE_ORDERED_FLIGHT = "DELETE FROM orders_flights WHERE order_id =?";

	@Override
	public Flight getFlightById(int flightId) {
		Flight flight = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_FLIGHT_BY_ID);
			ps.setInt(1, flightId);
			rs = ps.executeQuery();
			while (rs.next()) {
				flight = getFlightFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return flight;
	}

	@Override
	public List<Flight> getAllFlights() {
		List<Flight> flightsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_FLIGHTS);
			rs = ps.executeQuery();
			while (rs.next()) {
				flightsList.add(getFlightFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return flightsList;
	}

	@Override
	public List<Flight> getFlightsByPeriod(String start, String end) {
		List<Flight> flightsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_FLIGHT_BY_PERIOD);
			ps.setDate(1, DateService.toSqlDate(start));
			ps.setDate(2, DateService.toSqlDate(end));
			rs = ps.executeQuery();
			while (rs.next()) {
				flightsList.add(getFlightFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return flightsList;
	}

	@Override
	public boolean createFlight(String departureDate, String fromCity, String toCity, int flightTime, int price) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		java.sql.Date sqlDeparturetDate = DateService.toSqlDate(departureDate);

		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_FLIGHT);
			ps.setDate(1, sqlDeparturetDate);
			ps.setString(2, fromCity);
			ps.setString(3, fromCity);
			ps.setString(4, toCity);
			ps.setString(5, toCity);
			ps.setInt(6, flightTime);
			ps.setInt(7, price);

			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean updateFlight(int flightId, String departureDate, String fromCity, String toCity, int flightTime,
			int price) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		java.sql.Date sqlDeparturetDate = DateService.toSqlDate(departureDate);

		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(UPDATE_FLIGHT);
			ps.setDate(1, sqlDeparturetDate);
			ps.setString(2, fromCity);
			ps.setString(3, fromCity);
			ps.setString(4, toCity);
			ps.setString(5, toCity);
			ps.setInt(6, flightTime);
			ps.setInt(7, price);
			ps.setInt(8, flightId);

			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean deleteFlight(int flightId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_FLIGHT);
			ps.setInt(1, flightId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean orderFlight(Integer orderId, int flightId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(ORDER_FLIGHT);
			ps.setInt(1, orderId);
			ps.setInt(2, flightId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	public boolean deleteOrderedFlight(int orderId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_ORDERED_FLIGHT);
			ps.setInt(1, orderId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;

	}

	// Utility methods
	private static Flight getFlightFromDb(ResultSet rs) throws SQLException {
		return new Flight(rs.getInt("flight_id"), rs.getString("from_city_name"), rs.getString("to_city_name"),
				rs.getDate("departure"), rs.getInt("flight_time"), rs.getInt("price"));

	}


}
