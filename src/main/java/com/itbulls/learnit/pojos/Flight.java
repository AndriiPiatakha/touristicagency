package com.itbulls.learnit.pojos;

import java.util.Date;

public class Flight {

	private int flightId;
	private String from;
	private String to;
	private Date departureDate;
	private int flightTime;
	private int price;

	public Flight(int flightId, String from, String to, Date departureDate, int flightTime, int price) {
		this.flightId = flightId;
		this.from = from;
		this.to = to;
		this.departureDate = departureDate;
		this.flightTime = flightTime;
		this.price = price;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
