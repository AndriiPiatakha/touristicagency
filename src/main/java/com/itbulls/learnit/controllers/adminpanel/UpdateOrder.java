package com.itbulls.learnit.controllers.adminpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.OrderFacade;

@WebServlet(name = "UpdateOrder", urlPatterns = { "/adminpanel/update/order" }, loadOnStartup = 1)
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderFacade oFacade = new OrderFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean delete = "true".equals(req.getParameter("delete"));
		if (delete) {
			oFacade.deleteOrder(id);
		}
	}

}
