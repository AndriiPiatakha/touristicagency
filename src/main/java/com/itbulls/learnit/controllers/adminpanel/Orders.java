package com.itbulls.learnit.controllers.adminpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.RegistrationFacade;

@WebServlet(name = "Orders", urlPatterns = "/adminpanel/orders", loadOnStartup = 1)
public class Orders extends HttpServlet {

	private static final long serialVersionUID = 1L;
	RegistrationFacade rf = new RegistrationFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.getRequestDispatcher("/jsp/orders.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
