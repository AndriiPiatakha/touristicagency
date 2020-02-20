package com.itbulls.learnit.controllers.auth;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbulls.learnit.pojos.User;
import com.itbulls.learnit.utilities.AuthService;

/**
 * @author i.lisovitskyi Servlet implementation class LoginController A
 *         controller for handling user authentication and login
 */
@WebServlet(name = "Login", urlPatterns = "/login", loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private String url;
	private int loginAttempts;

	public Login() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "";
		session = req.getSession();
		if (session.getAttribute("user") == null) {
			url = "jsp/index.jsp";
			req.setAttribute("displayLogin", "block;");
			req.getRequestDispatcher(url).forward(req, resp);
		} else {
			url = "dashboard";
			resp.sendRedirect(url);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		// get the number of logins
		if (session.getAttribute("loginattempts") == null) {
			loginAttempts = 0;
		}
		// exceeded loggings
		if (loginAttempts > 2) {
			String errorMessage = "Error: Number of Login Attempts Exceeded";
			req.setAttribute("errorMessage", errorMessage);
			// TODO ajax here
			url = "jsp/index.jsp";
		} else {
			// proceed
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			boolean remember = "on".equals(req.getParameter("remember"));
			User user = null;
			Optional<Cookie> remembered = AuthService.getRememberMeCookie(req);
			if (remembered.isPresent()) {
				user = AuthService.loginRememberedUser(session, req);
				if (user == null) {
					user = AuthService.login(session, req, resp, username, password, remember);
				}
			} else {
				user = AuthService.login(session, req, resp, username, password, remember);
			}
			if (user != null) {
				url = "dashboard";
				resp.sendRedirect(url);
				
			} else {
				req.setAttribute("displayLogin", "block;");
				req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
			}
		}
	}
}
