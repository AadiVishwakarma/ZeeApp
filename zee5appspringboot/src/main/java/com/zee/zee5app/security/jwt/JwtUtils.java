package com.zee.zee5app.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//this class is to provide the token, validating the token
public class JwtUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);
	
	
	//read jstSecret
	@Value("${zee5app.app.jwtSecret}")
	private String jwtSecret;
	
	//read exp value
	private int jwtExpiryValue;
}
