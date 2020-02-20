package com.itbulls.learnit.facades;

import java.util.List;

import com.itbulls.learnit.dao.impl.TourDaoImpl;
import com.itbulls.learnit.pojos.Tour;

public class TourFacade {
	TourDaoImpl tDao = new TourDaoImpl();
	
	public List<Tour> getTours(){
		return tDao.getAllTours();
	}
	public Tour getTourById(int id) {
		return tDao.getTourById(id);
	}
	
	public List<Tour> getToursByPeriod(String start, String end){
		return tDao.getToursByPeriod(start, end);
	}
	public boolean createTour(String name, String description, String start, String end, int price, String language) {
		return tDao.createTour(name, description, start, end, price, language);
	}
	public boolean updateTour(int tourId, String name, String description, String start, String end, int price, String language) {
		return tDao.updateTour(tourId, name, description, start, end, price, language);
	}
	
	public boolean deleteTour(int tourId) {
		return tDao.deleteTour(tourId);
	}
	
	public boolean deleteOrderedTour(int orderId) {
		return tDao.deleteOrderedTour(orderId);
	}
	
	public boolean orderTour(int orderId, int tourId) {
		return tDao.orderTour(orderId, tourId);
	}

}
