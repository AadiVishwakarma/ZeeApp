package com.zee.zee5app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration  // it is used to mark on config class/classes
//here we will hold all commonly required objects for our application

@ComponentScan("com.zee.zee5app")

@PropertySource("classpath:application.properties")  //it is responsible for reaidng the property file


public class Config {
	//config: db related, reading prop files, commonly read beans(passwordEncoder)
	
	@Autowired //will bring the already created objects based on the name(ref name)/type
	Environment environment;
	
	
	@Bean //responsible for applying singleton design for methods
	// rule 1: if we weill not specify the bean name then it will take/consider the method name as bean name.
	public DataSource dataSource()
	{
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		basicDataSource.setDefaultAutoCommit(false);
		
		return basicDataSource;
	}
	
}
