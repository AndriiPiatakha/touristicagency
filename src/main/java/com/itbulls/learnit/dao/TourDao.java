package com.itbulls.learnit.dao;

import java.util.List;

import com.itbulls.learnit.pojos.Tour;

public interface TourDao {
	Tour getTourById(int yourId);

	List<Tour> getAllTours();

	List<Tour> getToursByPeriod(String start, String end);

	boolean createTour(String name, String description, String start, String end, int price, String language);

	boolean updateTour(int tourId, String name, String description, String start, String end, int price,
			String language);

	boolean deleteTour(int tourId);

	boolean orderTour(int orderId, int tourId);

	boolean deleteOrderedTour(int orderId);
}
