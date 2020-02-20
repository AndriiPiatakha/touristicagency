package com.itbulls.learnit.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.RentalFacade;
import com.itbulls.learnit.pojos.Rental;


@WebServlet(name = "RentalPage", urlPatterns = {"/dashboard/rental", "/adminpanel/dashboard/rental"}, loadOnStartup = 1)
public class RentalPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RentalFacade rentalFacade = new RentalFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Rental rental = rentalFacade.getRentalById(id);
			request.setAttribute("rental", rental);
			request.getRequestDispatcher("/jsp/rental.jsp").forward(request, response);
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
