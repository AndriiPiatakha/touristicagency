package com.itbulls.learnit.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 
 * @author i.lisovitskyi
 *This class converts plain text password to a SHA256 hash.
 */
public final class PasswordService {
	/**
	 * Encrypt strig pass to a hashed SHA 256 encrypted version
	 */
	public static String encrypt(String pass) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			md.update(pass.getBytes("UTF-8"));
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte raw[] = md.digest();
		String hash = Base64.getEncoder().encodeToString(raw);
		return hash;
	}
}
