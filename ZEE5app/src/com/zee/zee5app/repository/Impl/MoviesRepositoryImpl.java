package com.zee.zee5app.repository.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.MovieIdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.MovieRepository;


public class MoviesRepositoryImpl implements MovieRepository {

	//private Movie[] movies = new Movie[10];
	//private static int count = -1;
	
	private HashSet<Movie> hashSet = new HashSet<>();
	
	
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
		boolean result = this.hashSet.add(movie);
		if(result)
		{
			return "movie added successfully";
		}
		else
		{
			return "failed to add movie";
		}
	}

	@Override
	public String deleteMovie(String id) throws MovieIdNotFoundException {
		// TODO Auto-generated method stub
		Optional <Movie> optional = this.getMovieById(id);
		
		if(optional.isPresent())
		{
			boolean result = hashSet.remove(optional.get());
			if(result)
			{
				return "Movie successfully deleted";
			}
			else
			{
				return "Movie failed to delete";
			}
		}

		return "fail";
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws MovieIdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteMovie(id);
		if(result=="Failed")
			return "Failed to delete movie";
		result = this.addMovie(movie);
		if(result=="Fail")
			return "Failed to add movie";
		return "movie details modified";
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws MovieIdNotFoundException{
		// TODO Auto-generated method stub
		Movie movie2 = null;
		for (Movie movie : hashSet) {
			if(movie.getId().equals(id))
			{
				//return Optional.of(subscription);
				movie2 = movie;
			}
		}
		return Optional.ofNullable(Optional.of(movie2).orElseThrow(()-> new MovieIdNotFoundException("movie id not found")));
	}

	@Override
	public Movie[] getAllMovie() {
		// TODO Auto-generated method stub
		Movie movie[] = new Movie[hashSet.size()];
		
		return hashSet.toArray(movie);
	}
	
	@Override
	public HashSet<Movie> getAllMovieDetails()
	{
		return hashSet;
	}

}
