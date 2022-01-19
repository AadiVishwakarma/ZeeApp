package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movie;


public interface MovieRepository {
	
	public String addMovie(Movie movie);
	public String deleteMovie(String id);
	public String modifyMovie(String id, Movie movie);
	public Movie getMovieById(String id);
	public Movie[] getAllMovie();

}
