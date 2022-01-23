package com.zee.zee5app.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.MovieIdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;


public interface MovieRepository {
	
	public String addMovie(Movie movie);
	public String deleteMovie(String id) throws MovieIdNotFoundException;
	public String modifyMovie(String id, Movie movie) throws MovieIdNotFoundException, NameNotFoundException;
	public Optional<Movie> getMovieById(String id) throws MovieIdNotFoundException;
	public Movie[] getAllMovie();
	public HashSet<Movie> getAllMovieDetails();

}
