package com.itbulls.learnit.pojos;

public class Hotel {
	private int hotelId;
	private String name;
	private String address;
	private int suitePrice;
	private String city;

	public Hotel(int hotelId, String name, String address, int suitePrice, String city) {
		this.hotelId = hotelId;
		this.name = name;
		this.address = address;
		this.suitePrice = suitePrice;
		this.city = city;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSuitePrice() {
		return suitePrice;
	}

	public void setSuitePrice(int suitePrice) {
		this.suitePrice = suitePrice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
