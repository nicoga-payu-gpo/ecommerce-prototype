/*
 * PayU Latam - Copyright (c) 2013 - 2020
 * http://www.payu.com.co
 */
package com.prototype.ecommerce.utils;

import com.prototype.ecommerce.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that generates a JWT authorization token based on a {@linkplain User}
 *
 * @author Nicolas Garcia (nicolas.garcia@payulatam.com)
 * @version 1.0
 * @since 1.0
 */
public class Token {

	/**
	 * User for token generation.
	 */
	private User user;

	/**
	 * JWT authentication token of the user.
	 */
	private final String token;

	/**
	 * Constructor.
	 *
	 * @param user User for token genetarion.
	 */
	public Token(User user) {
		this.user = user;
		token=createUserToken();
	}

	/**
	 * Generates a JWT authorization token for the user.
	 *
	 * @return Generated token.
	 */
	public String createUserToken(){
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(user.getRole().trim());

		return Jwts
				.builder()
				.setId("ecommerce")
				.setSubject(user.getEmail())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public String getToken() {

		return token;
	}


}
