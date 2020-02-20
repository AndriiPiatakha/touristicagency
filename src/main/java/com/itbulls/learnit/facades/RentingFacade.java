package com.itbulls.learnit.facades;

import java.util.List;

import com.itbulls.learnit.dao.impl.RentalReceiptDaoImpl;
import com.itbulls.learnit.pojos.RentalReceipt;

public class RentingFacade {
	RentalReceiptDaoImpl bDao = new RentalReceiptDaoImpl();

	public List<RentalReceipt> getBookings() {
		return bDao.getAllRentalReceipts();
	}

	public RentalReceipt getReceiptById(int id) {
		return bDao.getRentalReceiptById(id);
	}

	public List<RentalReceipt> getReceiptsByOrderId(int orderId) {
		return bDao.getRentalReceiptsByOrderId(orderId);
	}

	public boolean createReceipt(int orderId, int rentalId, String from, String to, int price) {
		return bDao.createRentalReceipt(orderId, rentalId, from, to, price);
	}

	public boolean deleteReceipt(int receiptId) {
		return bDao.deleteRentalReceipt(receiptId);
	}

	public boolean updateReceipt(int receiptId, int orderId, int rentalId, String from, String to, int price) {
		return bDao.updateRentalReceipt(receiptId, orderId, rentalId, from, to, price);
	}

}
