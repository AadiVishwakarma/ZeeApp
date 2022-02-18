package com.learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.learning.utils.PasswordUtils;



public class Config {

	@Autowired //will bring the already created objects based on the name(ref name)/type
	Environment environment;
	
	@Bean
	public PasswordUtils passwordUtils()
	{
		return new PasswordUtils();
	}
	
}
