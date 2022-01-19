package com.zee.zee5app.repository.Impl;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.MovieRepository;


public class MoviesRepositoryImpl implements MovieRepository {

	private Movie[] movies = new Movie[10];
	private static int count = -1;
	
	private static MovieRepository movieRepository;
	public static MovieRepository getInstance() {
		if(movieRepository==null)
			movieRepository = new MoviesRepositoryImpl();
		return movieRepository;
	}
	
	private MoviesRepositoryImpl() {
		
	}
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		if(count == movies.length-1) {
			Movie temp[] = new Movie[movies.length*4];
			System.arraycopy(movie, 0, temp, 0, movies.length);
			movies = temp;
			movies[++count] = movie;
			return "Success2";	
		}
		movies[++count] = movie;
		return "Success2";
	}

	@Override
	public String deleteMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		for (Movie movie : movies) {
			if(movie!=null && movie.getId().equals(id))
				return movie;	
		}
		return null;
	}

	@Override
	public Movie[] getAllMovie() {
		// TODO Auto-generated method stub
		return movies;
	}

}
