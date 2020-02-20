package com.itbulls.learnit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.TourFacade;
import com.itbulls.learnit.pojos.Tour;


@WebServlet(name = "TourPage", urlPatterns = {"/dashboard/tour", "/adminpanel/dashboard/tour"}, loadOnStartup = 1)
public class TourPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourFacade tourFacade = new TourFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Tour tour = tourFacade.getTourById(id);
			request.setAttribute("tour", tour);
			request.getRequestDispatcher("/jsp/tour.jsp").forward(request, response);
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
