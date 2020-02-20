package com.itbulls.learnit.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbulls.learnit.facades.HotelFacade;
import com.itbulls.learnit.facades.RentalFacade;
import com.itbulls.learnit.pojos.Hotel;
import com.itbulls.learnit.pojos.Rental;

@WebServlet(name = "Dashboard", urlPatterns = "/dashboard", loadOnStartup = 1)
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	RentalFacade rFacade = new RentalFacade();
	HotelFacade hFacade = new HotelFacade();
	List<String> rentalCities = rFacade.getRentals().stream().map(Rental::getCity).collect(Collectors.toList());
	List<String> hotelCities = hFacade.getHotels().stream().map(Hotel::getCity).collect(Collectors.toList());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		if (session.getAttribute("user") != null) {
			req.setAttribute("rentalCities", rentalCities);
			req.setAttribute("hotelCities", hotelCities);
			req.getRequestDispatcher("jsp/userdashboard.jsp").forward(req, resp);
		} else {
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		if (session.getAttribute("user") != null) {
			req.getRequestDispatcher("jsp/userdashboard.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/");
			
		}
	}
}
