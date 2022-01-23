package com.zee.zee5app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.MovieIdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.Impl.MoviesRepositoryImpl;

public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository = MoviesRepositoryImpl.getInstance();
	private static MovieService service;	
	
	public static MovieService getInstance() {
		if(service == null)
			service = new MovieServiceImpl();
		return service;
	}
	
    private MovieServiceImpl() {
		
	}
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return this.movieRepository.addMovie(movie);
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws MovieIdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieById(id);
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepository.getAllMovie();
	}

	@Override
	public String deleteMovie(String id) throws MovieIdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.deleteMovie(id);
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws MovieIdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.modifyMovie(id, movie);
	}
	
	public HashSet<Movie> getAllMovieDetails() {
		return movieRepository.getAllMovieDetails();
	}

}
