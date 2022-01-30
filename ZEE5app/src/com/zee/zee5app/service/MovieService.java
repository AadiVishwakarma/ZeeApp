package com.zee.zee5app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.exception.MovieIdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

public interface MovieService {
	
	public String addMovie(Movie movie);
	public Optional<Movie> getMovieById(String id) throws MovieIdNotFoundException;
	public Movie[] getAllMovies();
	public String deleteMovie(String id) throws MovieIdNotFoundException;
	public String modifyMovie(String id, Movie movie) throws MovieIdNotFoundException, NameNotFoundException;
	
	public HashSet<Movie> getAllMovieDetails();
	
}
