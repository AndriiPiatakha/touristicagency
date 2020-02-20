package com.itbulls.learnit.controllers.adminpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.UserFacade;

@WebServlet(name = "CreateUser", urlPatterns = { "/adminpanel/create/user" }, loadOnStartup = 1)
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserFacade userFacade = new UserFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean create = "true".equals(request.getParameter("create"));
		
		String username = request.getParameter("user-name");
		String mail = request.getParameter("user-mail");
		String birthday = request.getParameter("user-birthday");
		int roleId = Integer.parseInt(request.getParameter("user-role-id"));
		String password = request.getParameter("password");
		if (create) {
			userFacade.createUser(username, mail, password, birthday, roleId);
		}
	}
}
