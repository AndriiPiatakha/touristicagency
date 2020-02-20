package com.itbulls.learnit.controllers.adminpanel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itbulls.learnit.facades.OrderFacade;
import com.itbulls.learnit.pojos.Order;

@WebServlet(name = "AllOrders", urlPatterns = "/adminpanel/orders/all", loadOnStartup = 1)
public class AllOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderFacade orderFacade = new OrderFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			List<Order> tours = orderFacade.getOrders();
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
