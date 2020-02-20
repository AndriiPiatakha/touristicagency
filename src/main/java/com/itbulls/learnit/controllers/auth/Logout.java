package com.itbulls.learnit.controllers.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbulls.learnit.utilities.AuthService;


@WebServlet(name = "Logout", urlPatterns = "/logout", loadOnStartup = 1)
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//delete user id from cookies
		AuthService.deleteRememberMeCookie(resp);
		// logout and redirect to front page
		req.getSession().invalidate();
		resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath() + "/"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("logout") != null) {
			// logout and redirect to front page
		}
	}
}
