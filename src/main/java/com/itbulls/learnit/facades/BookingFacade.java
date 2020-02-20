package com.itbulls.learnit.facades;

import java.util.List;

import com.itbulls.learnit.dao.impl.BookingDaoImpl;
import com.itbulls.learnit.pojos.Booking;

public class BookingFacade {
	BookingDaoImpl bDao = new BookingDaoImpl();

	public List<Booking> getBookings() {
		return bDao.getAllBookings();
	}

	public Booking getHotelById(int id) {
		return bDao.getBookingById(id);
	}

	public List<Booking> getBookingsByOrderId(int orderId) {
		return bDao.getBookingByOrderId(orderId);
	}

	public boolean createBooking(int orderId, int hotelId, String checkin, String checkout, int price, int nights) {
		return bDao.createBooking(orderId, hotelId, checkin, checkout, price, nights);
	}

	public boolean deleteBooking(int bookingId) {
		return bDao.deleteBooking(bookingId);
	}

	public boolean updateBooking(int bookingId, int orderId, int hotelId, String checkin, String checkout, int price,
			int nights) {
		return bDao.updateBooking(bookingId, orderId, hotelId, checkin, checkout, price, nights);
	}

}
