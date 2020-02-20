package com.itbulls.learnit.controllers.userprofile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.UserFacade;


@WebServlet(name = "UserProfile", urlPatterns = "/profile", loadOnStartup = 1)
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserFacade uFacade = new UserFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setAttribute("user",request.getSession().getAttribute("user"));
			request.getRequestDispatcher("/jsp/userprofile.jsp").forward(request, response);
	}



}
