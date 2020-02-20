package com.itbulls.learnit.dao;

import java.util.List;

import com.itbulls.learnit.pojos.Rental;

public interface RentalDao {
	Rental getRentalById(int yourId);

	List<Rental> getAllRentals();

	List<Rental> getRentalsByOrderId(int orderId);

	boolean createRental(String name, String description, String fromDate, String toDate, int price, String city);

	boolean updateRental(int rentalId, String name, String description, String fromDate, String toDate, int price,
			String city);

	boolean deleteRental(int rentalId);

	List<Rental> getRentalsByCityName(String cityName);
}
