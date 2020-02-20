package com.itbulls.learnit.controllers.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.facades.UserFacade;

@WebServlet(name = "UpdateUser", urlPatterns = { "/adminpanel/update/user" }, loadOnStartup = 1)
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserFacade userFacade = new UserFacade();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		boolean edit = "true".equals(request.getParameter("edit"));
		String username = request.getParameter("user-name");
		String mail = request.getParameter("user-mail");
		String birthday = request.getParameter("user-birthday");
		int roleId = Integer.parseInt(request.getParameter("user-role-id"));
		String password = request.getParameter("password");
		if (edit) {
			userFacade.updateUser(userId, username, password, mail, birthday, roleId);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		boolean edit = "true".equals(request.getParameter("edit"));
		String username = request.getParameter("user-name");
		String mail = request.getParameter("user-mail");
		String birthday = request.getParameter("user-birthday");
		int roleId = Integer.parseInt(request.getParameter("user-role-id"));
		String password = request.getParameter("password");
		if (edit) {
			userFacade.updateUser(userId, username, password, mail, birthday, roleId);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean delete = "true".equals(req.getParameter("delete"));
		if (delete) {
			userFacade.deleteUser(id);
		}
	}

}
