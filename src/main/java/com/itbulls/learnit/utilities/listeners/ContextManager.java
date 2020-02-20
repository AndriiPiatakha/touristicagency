package com.itbulls.learnit.utilities.listeners;

import javax.servlet.ServletContext;

public class ContextManager {

	private static ServletContext context;

	public static void setServletContext(ServletContext context) {
		ContextManager.context = context;
	}

	public static ServletContext getServletContext() {
		return ContextManager.context;
	}

}
