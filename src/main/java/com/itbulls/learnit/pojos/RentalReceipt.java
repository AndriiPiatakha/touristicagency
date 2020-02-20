package com.itbulls.learnit.pojos;

import java.util.Date;

public class RentalReceipt {

	private int receiptId;
	private int orderId;
	private int rentalId;
	private Date pickUpDate;
	private Date dropOffDate;
	private int price;

	public RentalReceipt(int receiptId, int orderId, int rentalId, Date pickUpDate, Date dropOffDate, int price) {
		this.receiptId = receiptId;
		this.orderId = orderId;
		this.rentalId = rentalId;
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		this.price = price;
	}

	public int getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(Date dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}