package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.Impl.MoviesRepositoryImpl;

public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository = MoviesRepositoryImpl.getInstance();
	private static MovieService service;	
	
	public static MovieService getInstance() throws IOException {
		if(service == null)
			service = new MovieServiceImpl();
		return service;
	}
	
    private MovieServiceImpl() throws IOException {
		
	}
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.addMovie(movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException,InvalidIdLengthException,InvalidNameException, NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Override
	public Movie[] getAllMovies() throws InvalidIdLengthException,InvalidNameException, LocationNotFoundException, NameNotFoundException{
		// TODO Auto-generated method stub
		return movieRepository.getAllMovie();
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.deleteMovie(id);
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.modifyMovie(id, movie);
	}
	
	public Optional<HashSet<Movie>> getAllMovieDetails() throws InvalidIdLengthException,InvalidNameException, LocationNotFoundException, NameNotFoundException{
		return movieRepository.getAllMovieDetails();
	}

}
