package com.itbulls.learnit.controllers.adminpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.TourFacade;

@WebServlet(name = "CreateTour", urlPatterns = { "/adminpanel/create/tour" }, loadOnStartup = 1)
public class CreateTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourFacade tourFacade = new TourFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean create = "true".equals(request.getParameter("create"));
		String name = request.getParameter("tour-name");
		String description = request.getParameter("description");
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		int price = Integer.parseInt(request.getParameter("price"));
		String language = request.getParameter("language");

		if (create) {
			tourFacade.createTour(name, description, start, end, price, language);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean create = "true".equals(request.getParameter("create"));
		String name = request.getParameter("tour-name");
		String description = request.getParameter("description");
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		int price = Integer.parseInt(request.getParameter("tour-price"));
		String language = request.getParameter("tour-language");
		if (create) {
			tourFacade.createTour(name, description, start, end, price, language);
		}
	}
}
