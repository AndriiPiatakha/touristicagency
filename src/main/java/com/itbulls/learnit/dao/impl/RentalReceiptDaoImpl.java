package com.itbulls.learnit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itbulls.learnit.dao.RentalReceiptDao;
import com.itbulls.learnit.pojos.RentalReceipt;
import com.itbulls.learnit.utilities.DateService;
import com.itbulls.learnit.utilities.db.ConnectionManager;

public class RentalReceiptDaoImpl implements RentalReceiptDao {

	private final static String CREATE_RENTAL_RECEIPT = "INSERT INTO orders_rental (order_id, rental_id, `from`, `to`, price) VALUES(?, ?, ?, ?, ?)";
	private final static String UPDATE_RENTAL_RECEIPT = "UPDATE `protraveldb`.`orders_rental` SET `order_id`= ?, `rental_id`= ?, `from`= ?, `to`= ?, `price`= ?, WHERE `receipt_id`= ?;";

	private final static String DELETE_RENTAL_RECEIPT = "DELETE FROM orders_rental WHERE receipt_id = ?";
	private final static String SELECT_RENTAL_RECEIPT_BY_ID = "SELECT * FROM orders_rental WHERE receipt_id = ?";
	private final static String SELECT_RENTAL_RECEIPT_BY_ORDER_ID = "SELECT * FROM orders_rental WHERE order_id = ?";

	private final static String SELECT_ALL_RENTAL_RECEIPTS = "SELECT * FROM orders_rental";

	@Override
	public RentalReceipt getRentalReceiptById(int receiptId) {
		RentalReceipt booking = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_RENTAL_RECEIPT_BY_ID);
			ps.setInt(1, receiptId);
			rs = ps.executeQuery();
			while (rs.next()) {
				booking = getRentalReceiptFromDb(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return booking;
	}

	@Override
	public List<RentalReceipt> getAllRentalReceipts() {
		List<RentalReceipt> receiptsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_ALL_RENTAL_RECEIPTS);
			rs = ps.executeQuery();
			while (rs.next()) {
				receiptsList.add(getRentalReceiptFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return receiptsList;
	}

	@Override
	public List<RentalReceipt> getRentalReceiptsByOrderId(int orderId) {
		List<RentalReceipt> receiptsList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(SELECT_RENTAL_RECEIPT_BY_ORDER_ID);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			while (rs.next()) {
				receiptsList.add(getRentalReceiptFromDb(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return receiptsList;
	}

	@Override
	public boolean deleteRentalReceipt(int receiptId) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(DELETE_RENTAL_RECEIPT);
			ps.setInt(1, receiptId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean updateRentalReceipt(int receiptId, int orderId, int rentalId, String from, String to, int price) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(UPDATE_RENTAL_RECEIPT);
			ps.setInt(1, orderId);
			ps.setInt(2, rentalId);
			ps.setDate(3, DateService.toSqlDate(from));
			ps.setDate(4, DateService.toSqlDate(to));
			ps.setInt(5, price);
			ps.setInt(6, receiptId);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	@Override
	public boolean createRentalReceipt(int orderId, int rentalId, String from, String to, int price) {
		PreparedStatement ps = null;
		int updatedRows = 0;
		try (Connection conn = ConnectionManager.getConnection()) {
			ps = conn.prepareStatement(CREATE_RENTAL_RECEIPT);
			ps.setInt(1, orderId);
			ps.setInt(2, rentalId);
			ps.setDate(3, DateService.toSqlDate(from));
			ps.setDate(4, DateService.toSqlDate(to));
			ps.setInt(5, price);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows == 1;
	}

	// Utility methods
	private static RentalReceipt getRentalReceiptFromDb(ResultSet rs) throws SQLException {
		return new RentalReceipt(rs.getInt("receipt_id"), rs.getInt("order_id"), rs.getInt("rental_id"),
				rs.getDate("from"), rs.getDate("to"), rs.getInt("price"));

	}

}
