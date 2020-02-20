package com.itbulls.learnit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.HotelFacade;
import com.itbulls.learnit.pojos.Hotel;


@WebServlet(name = "HotelPage", urlPatterns = {"/dashboard/hotel", "/adminpanel/dashboard/hotel"}, loadOnStartup = 1)
public class HotelPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HotelFacade hotelFacade = new HotelFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Hotel hotel = hotelFacade.getHotelById(id);
			request.setAttribute("hotel", hotel);
			request.getRequestDispatcher("/jsp/hotel.jsp").forward(request, response);
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
