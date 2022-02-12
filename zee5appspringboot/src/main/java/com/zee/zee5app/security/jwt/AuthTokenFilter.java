	package com.zee.zee5app.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.security.services.UserDetailsServiceImpl;

public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
	
	
	
	
	//purpose of do filter method: every request will pass through this and this method will validate your token
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//we need to parse the token, so need to retrieve the token from request argument
		
		try {
		String jwt = parseJwt(request);
		if(jwt != null && jwtUtils.validateJwtToken(jwt))
		{
			String username = jwtUtils.getUserNameFromJwtToken(jwt);
			
			UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null , userDetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			
		}
		}
		catch(Exception e)
		{
			//logger.error(e.getMessage());
			logger.error("cannot set user authentication{}",e);
			
		}
		
		filterChain.doFilter(request, response);
		//internally it will call next filter/ Servlet
		
		
	}
	
	//separate method to retrieve from request
	private String parseJwt(HttpServletRequest request)
	{
		String headerAuth = request.getHeader("Authorization");
		//jwt token will be placed inside the header
		//jwt token ==> header(authorization header)
		// request has 3 parts: header, requestline, requestbody
		
		if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer "))
		{
			return headerAuth.substring(7,headerAuth.length());
			//7th place onwards we will get actual token
		}
		
		return null;
		
	}

}
