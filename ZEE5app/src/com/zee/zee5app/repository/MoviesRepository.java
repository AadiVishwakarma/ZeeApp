package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movies;

public class MoviesRepository {

	private Movies[] movie = new Movies[10];
	
	private MoviesRepository()
	{
		
	}
	
	public static MoviesRepository moviesRepository;
	public static MoviesRepository getInstance()
	{
		if(moviesRepository == null)
			moviesRepository = new MoviesRepository();
		return moviesRepository;
	}
}
