package com.itbulls.learnit.utilities;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itbulls.learnit.pojos.User;

public class AuthService {
	private static final String COOKIE_NAME = "PROTRAVELID";
	public static final String SESSION_USERNAME = "username";

	public static User login(HttpSession session, HttpServletRequest req, HttpServletResponse resp, String username,
			String password, boolean rememberMe) {
		User authenticUser = UserService.authenticUser(username, password);
		if (authenticUser != null) {
			// invalidate current session, then get new session for our user (prevents
			// session hijacking)
			session.invalidate();
			session = req.getSession(true);
			session.setAttribute("user", authenticUser);
			session.setAttribute(SESSION_USERNAME, username);
			if (rememberMe) {
				rememberUser(authenticUser, resp);
			}
			return authenticUser;
		}
		return null;
	}

	public static User loginRememberedUser(HttpSession session, HttpServletRequest request) {
		Optional<Cookie> rememberMeCookie = getRememberMeCookie(request);
		User rememberedUser = null;
		if (rememberMeCookie.isPresent()) {
			String id = rememberMeCookie.get().getValue();
			//if id null then id in the Map rememberedUsers in UserService does not mathch the id which is stored at the client;
				rememberedUser = UserService.getRememberedUser(id);
			if (rememberedUser != null) {
				session.invalidate();
				session = request.getSession(true);
				session.setAttribute("user", rememberedUser);
				session.setAttribute(SESSION_USERNAME, rememberedUser.getUsername());
				return rememberedUser;
			}
		}
		return rememberedUser;
	}

	public static void deleteRememberMeCookie(HttpServletResponse resp) {
		Cookie cookie = new Cookie(COOKIE_NAME, "");
		cookie.setPath("");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
	}

	public static Optional<Cookie> getRememberMeCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			return Arrays.stream(cookies)
					.filter(c -> c.getName()
					.equals(COOKIE_NAME))
					.filter(Objects::nonNull)
					.findFirst();
		}else {
			return Optional.empty();
		}
	}

	private static void rememberUser(User user, HttpServletResponse resp) {
		String id = UserService.rememberUser(user);
		Cookie cookie = new Cookie(COOKIE_NAME, id);
		cookie.setPath("");
		cookie.setMaxAge(60 * 60 * 24 * 30); // valid for 30 days
		resp.addCookie(cookie);
	}
}
