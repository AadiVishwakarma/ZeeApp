package com.zee.zee5app.service;

import com.zee.zee5app.repository.MoviesRepository;

public class MoviesService {
	
	private MoviesRepository movieRepo = MoviesRepository.getInstance();
	
	private static int count=-1;
	
	private MoviesService()
	{
		
	}
	
	private static MoviesService movieservice = null;
	
	public static MoviesService getInstance()
	{
		if(movieservice==null)
		{
			movieservice = new MoviesService();
		}
		return movieservice;
	}
	
	
}
