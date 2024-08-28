package com.coffeetalk.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
		StringBuilder hexString = new StringBuilder();
		
		for (byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if(hex.length() == 1) {
				hexString.append("0");
			}
			
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
	
	public static boolean verifyPassword(String password1, String password2) throws NoSuchAlgorithmException {
		return hashPassword(password1).equals(password2);
	}
}
