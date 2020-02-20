package com.itbulls.learnit.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itbulls.learnit.facades.HotelFacade;
import com.itbulls.learnit.pojos.Hotel;

@WebServlet(name = "HotelsCity", urlPatterns = "/hotels/city", loadOnStartup = 1)
public class HotelsCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HotelFacade hotelFacade = new HotelFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String city = request.getParameter("city");
		List<Hotel> tours = hotelFacade.getHotelByCity(city);
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
