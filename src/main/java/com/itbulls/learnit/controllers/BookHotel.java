package com.itbulls.learnit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbulls.learnit.facades.BookingFacade;
import com.itbulls.learnit.facades.OrderFacade;
import com.itbulls.learnit.utilities.DateService;

@WebServlet(name = "BookHotel", urlPatterns = "/dashboard/book/hotel", loadOnStartup = 1)
public class BookHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookingFacade bookingFacade = new BookingFacade();
	OrderFacade orderFacade = new OrderFacade();
	HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("user"));
		int hotelId = Integer.parseInt(request.getParameter("id"));
		String checkin = (String) request.getParameter("startDate");
		String checkout = (String) request.getParameter("endDate");
		int nights = (int) (DateService.daysDifference(checkin, checkout)) + 1;
		int suitPrice = Integer.parseInt(request.getParameter("price"));
		int price = nights * suitPrice;

		session = request.getSession();
		Integer orderId = (Integer) session.getAttribute("orderId");
		if (orderId == null) {
			orderId = orderFacade.createOrder(userId);
			session.setAttribute("order", orderId);
		}
		bookingFacade.createBooking(orderId, hotelId, checkin, checkout, price, nights);
	}

}
