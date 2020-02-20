package com.itbulls.learnit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.FlightFacade;
import com.itbulls.learnit.pojos.Flight;


@WebServlet(name = "FlightPage", urlPatterns = {"/dashboard/flight", "/adminpanel/dashboard/flight"}, loadOnStartup = 1)
public class FlightPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightFacade flightFacade = new FlightFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Flight flight = flightFacade.getFlightById(id);
			request.setAttribute("flight", flight);
			request.getRequestDispatcher("/jsp/flight.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.getRequestDispatcher("/login").forward(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
