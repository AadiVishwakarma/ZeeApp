package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movie;
//import com.zee.zee5app.repository.MovieRepository;

public interface MovieService {
	
	public String addMovie(Movie movie);
	public Movie getMovieById(String id);
	public Movie[] getAllMovies();
	
}
