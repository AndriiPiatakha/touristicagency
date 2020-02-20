package com.itbulls.learnit.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itbulls.learnit.facades.FlightFacade;
import com.itbulls.learnit.pojos.Flight;

@WebServlet(name = "FlightsByPeriod", urlPatterns = "/flights/period", loadOnStartup = 1)
public class FlightsByPeriod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightFacade flightFacade = new FlightFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		List<Flight> tours = flightFacade.getFlightsByPeriod(start, end);
		String json = new Gson().toJson(tours);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
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
