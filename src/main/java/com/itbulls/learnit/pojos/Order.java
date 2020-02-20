package com.itbulls.learnit.pojos;

public class Order {
	// required
	private int userId;
	private int orderId;
	private String userEmail;
	// optional
	private int tourId;
	private String tourName;
	private int tourPrice;
	private int flightId;
	private int flightPrice;
	private int hotelId;
	private int hotelPrice;
	private int rentalId;
	private int rentalPrice;

	public Order(OrderBuilder builder) {
		this.userId = builder.userId;
		this.orderId = builder.orderId;
		this.userEmail = builder.userEmail;
		this.tourId = builder.tourId;
		this.tourName = builder.tourName;
		this.tourPrice = builder.tourPrice;
		this.flightId = builder.flightId;
		this.flightPrice = builder.flightPrice;
		this.hotelId = builder.hotelId;
		this.hotelPrice = builder.hotelPrice;
		this.rentalId = builder.rentalId;
		this.rentalPrice = builder.rentalPrice;
	}

	public int getUserId() {
		return userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public int getTourId() {
		return tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public int getTourPrice() {
		return tourPrice;
	}

	public int getFlightId() {
		return flightId;
	}

	public int getFlightPrice() {
		return flightPrice;
	}

	public int getHotelId() {
		return hotelId;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public int getRentalId() {
		return rentalId;
	}

	public int getRentalPrice() {
		return rentalPrice;
	}

	public static class OrderBuilder {
		// required
		private int userId;
		private int orderId;
		private String userEmail;
		// optional
		private int tourId;
		private String tourName;
		private int tourPrice;
		private int flightId;
		private int flightPrice;
		private int hotelId;
		private int hotelPrice;
		private int rentalId;
		private int rentalPrice;

		public OrderBuilder(int userId, int orderId, String userEmail) {
			this.userId = userId;
			this.orderId = orderId;
			this.userEmail = userEmail;
		}

		public OrderBuilder setRentalPrice(int rentalPrice) {
			this.rentalPrice = rentalPrice;
			return this;
		}

		public OrderBuilder setRentalId(int rentalId) {
			this.rentalId = rentalId;
			return this;
		}

		public OrderBuilder setHotelPrice(int hotelPrice) {
			this.hotelPrice = hotelPrice;
			return this;
		}

		public OrderBuilder setHotelId(int hotelId) {
			this.hotelId = hotelId;
			return this;
		}

		public OrderBuilder setFlightPrice(int flightPrice) {
			this.flightPrice = flightPrice;
			return this;
		}

		public OrderBuilder setFlightId(int flightId) {
			this.flightId = flightId;
			return this;
		}

		public OrderBuilder setTourPrice(int tourPrice) {
			this.tourPrice = tourPrice;
			return this;
		}

		public OrderBuilder setTourName(String tourName) {
			this.tourName = tourName;
			return this;
		}

		public OrderBuilder setTourId(int tourId) {
			this.tourId = tourId;
			return this;
		}

	}

}
