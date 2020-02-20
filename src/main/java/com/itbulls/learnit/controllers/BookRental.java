package com.itbulls.learnit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbulls.learnit.facades.OrderFacade;
import com.itbulls.learnit.facades.RentingFacade;
import com.itbulls.learnit.utilities.DateService;

@WebServlet(name = "BookRental", urlPatterns = "/dashboard/book/rental", loadOnStartup = 1)
public class BookRental extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderFacade orderFacade = new OrderFacade();
	RentingFacade rentingFacade = new RentingFacade();
	HttpSession session;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("user"));
		int rentalId = Integer.parseInt(request.getParameter("id"));
		String pickup = (String) request.getParameter("startDate");
		String dropoff = (String) request.getParameter("endDate");
		int days = (int) (DateService.daysDifference(pickup, dropoff)) + 1;
		int rentalPrice = Integer.parseInt(request.getParameter("price"));
		int price = days * rentalPrice;

		session = request.getSession();
		Integer orderId = (Integer) session.getAttribute("orderId");
		if (orderId == null) {
			orderId = orderFacade.createOrder(userId);
			session.setAttribute("order", orderId);
		}
		rentingFacade.createReceipt(orderId, rentalId, pickup, dropoff, price);
		
	}

}
