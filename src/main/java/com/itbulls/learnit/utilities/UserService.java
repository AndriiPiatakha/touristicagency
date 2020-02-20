package com.itbulls.learnit.utilities;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import com.itbulls.learnit.facades.LoginFacade;
import com.itbulls.learnit.pojos.User;

public class UserService {

	private static SecureRandom random = new SecureRandom();
	private static Map<String, User> rememberedUsers = new HashMap<>();
	private static LoginFacade lf = new LoginFacade();

	public static User authenticUser(String username, String password) {
		return lf.authentificatedUser(username, password);
	}

	public static String rememberUser(User user) {
		//TODO replace this with hashed user ids in db
		String randomId = new BigInteger(130, random).toString(32);
		rememberedUsers.put(randomId, user);
		return randomId;
	}

	public static User getRememberedUser(String id) {
		return rememberedUsers.get(id);
	}

	public static void removeRememberedUser(String id) {
		rememberedUsers.remove(id);
	}
}
