package com.zee.zee5app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
//import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.exception.NameNotFoundException;

public interface MovieService {
	
	public String addMovie(Movie movie);
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, NameNotFoundException, LocationNotFoundException;
	public Movie[] getAllMovies() throws InvalidIdLengthException, InvalidNameException, LocationNotFoundException, NameNotFoundException;
	public String deleteMovie(String id) throws IdNotFoundException, NameNotFoundException;
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException, NameNotFoundException;
	
	public Optional<HashSet<Movie>> getAllMovieDetails() throws InvalidIdLengthException, InvalidNameException, LocationNotFoundException, NameNotFoundException;
	
}
