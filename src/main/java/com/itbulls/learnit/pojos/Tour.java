package com.itbulls.learnit.pojos;

import java.util.Date;

public class Tour {

	private int tourId;
	private String name;
	private String description;
	private Date start;
	private Date end;
	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	private int price;
	private String language;

	public Tour(int tourId, String name, String description, Date start, Date end, int price, String language) {
		this.tourId = tourId;
		this.name = name;
		this.description = description;
		this.start = start;
		this.end = end;
		this.price = price;
		this.language = language;
	}
}
