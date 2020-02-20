package com.itbulls.learnit.controllers.userprofile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbulls.learnit.facades.TourFacade;
import com.itbulls.learnit.pojos.User;

@WebServlet(name = "MyOrders", urlPatterns = "/myorders", loadOnStartup = 1)
public class MyOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourFacade tourFacade = new TourFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
	//	List<Tour> tours = tourFacade.ge;
		//String json = new Gson().toJson(tours);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	//	response.getWriter().write(json);
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
