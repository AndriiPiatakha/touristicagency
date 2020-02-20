package com.itbulls.learnit.pojos;

import java.util.Date;

public class Booking {
	private int bookingId;
	private int orderId;
	private int hotelId;
	private Date checkin;
	private Date checkout;
	private int nights;
	private int price;
	
	public Booking(int bookingId, int orderId, int hotelId, Date checkin, Date checkout, int nights, int price) {
		this.bookingId = bookingId;
		this.orderId = orderId;
		this.hotelId = hotelId;
		this.checkin = checkin;
		this.checkout = checkout;
		this.nights = nights;
		this.price = price;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public int getNights() {
		return nights;
	}
	public void setNights(int nights) {
		this.nights = nights;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
