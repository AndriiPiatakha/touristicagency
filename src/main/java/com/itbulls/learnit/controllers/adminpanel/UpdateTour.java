package com.itbulls.learnit.controllers.adminpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.TourFacade;

@WebServlet(name = "UpdateTour", urlPatterns = { "/adminpanel/update/tour" }, loadOnStartup = 1)
public class UpdateTour extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourFacade tourFacade = new TourFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean edit = "true".equals(request.getParameter("edit"));
		String name = request.getParameter("tour-name");
		String description = request.getParameter("description");
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		int price = Integer.parseInt(request.getParameter("price"));
		String language = request.getParameter("language");

		if (edit) {
			tourFacade.updateTour(id, name, description, start, end, price, language);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean edit = "true".equals(request.getParameter("edit"));
		String name = request.getParameter("tour-name");
		String description = request.getParameter("description");
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		int price = Integer.parseInt(request.getParameter("price"));
		String language = request.getParameter("language");

		if (edit) {
			boolean updated = tourFacade.updateTour(id, name, description, start, end, price, language);
			request.setAttribute("updated", updated);
			request.getRequestDispatcher("/jsp/admin.jsp").forward(request, response);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean delete = "true".equals(req.getParameter("delete"));
		if (delete) {
			tourFacade.deleteTour(id);
		}
	}

}
