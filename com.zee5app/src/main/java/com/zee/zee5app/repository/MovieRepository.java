package com.zee.zee5app.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;


public interface MovieRepository {
	
	public String addMovie(Movie movie);
	public String deleteMovie(String id) throws IdNotFoundException, NameNotFoundException;
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException, NameNotFoundException;
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, NameNotFoundException, LocationNotFoundException;
	public Movie[] getAllMovie() throws LocationNotFoundException, NameNotFoundException;
	public Optional<HashSet<Movie>> getAllMovieDetails() throws LocationNotFoundException, NameNotFoundException;

}
