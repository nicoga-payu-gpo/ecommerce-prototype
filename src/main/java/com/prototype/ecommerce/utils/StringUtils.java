/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Util that generate the MD5 hash of an String
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public class StringUtils {

	/**
	 * Generates the MD5 hash of a given string.
	 *
	 * @param string String which is going to be hashed.
	 * @return MD5 hash of the string.
	 */
	public static String getMD5Hash(String string) {

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(string.getBytes());
			byte[] bytes = messageDigest.digest();
			StringBuilder stringBuilder = new StringBuilder();
			for (byte aByte : bytes) {
				stringBuilder.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
			}
			return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {

		}
		return "";
	}

	/**
	 * Validate if a password corresponds to its MD5 hash.
	 *
	 * @param password     Password to validate.
	 * @param passwordHash MD5 hash of the real password.
	 * @return If the passwords are the same.
	 */
	public static boolean isPasswordValid(String password, String passwordHash) {

		return getMD5Hash(password).equals(passwordHash);
	}
}
