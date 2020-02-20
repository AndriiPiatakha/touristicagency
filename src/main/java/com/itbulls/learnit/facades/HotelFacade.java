package com.itbulls.learnit.facades;

import java.util.List;

import com.itbulls.learnit.dao.impl.HotelDaoImpl;
import com.itbulls.learnit.pojos.Hotel;

public class HotelFacade {
	HotelDaoImpl hDao = new HotelDaoImpl();
	
	public List<Hotel> getHotels(){
		return hDao.getAllHotels();
	}
	public Hotel getHotelById(int id) {
		return hDao.getHotelById(id);
	}
	public List<Hotel> getHotelByCity(String city) {
		return hDao.getHotelsByCity(city);
	}
	public boolean createHotel(String name, String address, int suitePrice, String city) {
		return hDao.createHotel(name, address, suitePrice, city);
	}
	public boolean deleteHotel(int hotelId) {
		return hDao.deleteHotel(hotelId);
	}

}
