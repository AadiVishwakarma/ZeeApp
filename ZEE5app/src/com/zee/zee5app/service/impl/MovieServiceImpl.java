package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.Impl.MoviesRepositoryImpl;

public class MovieServiceImpl implements MovieService {

	private MovieRepository repository = MoviesRepositoryImpl.getInstance();
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
		return this.repository.addMovie(movie);
	}

	@Override
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		return this.repository.getMovieById(id);
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		return repository.getAllMovie();
	}

}
