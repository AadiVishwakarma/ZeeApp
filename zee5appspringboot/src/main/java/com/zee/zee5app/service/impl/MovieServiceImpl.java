package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.repository.MovieRepository;


@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	
	
	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Movie addMovie(Movie movie){
		// TODO Auto-generated method stub
		
		movieRepository.findById(movie.getId());
		
		Movie movie2 = movieRepository.save(movie);
		
		if(movie2 != null)
		{
			return movie2;
		}
		else
		{
			return null;
		}
	}



	@Override
	public String modifyMovie(Long id, Movie movie) throws IdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Movie>> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}


	@Override
	public Optional<List<Movie>> getAllMovies()
			throws InvalidIdLengthException, InvalidNameException, LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public String deleteMovie(Long id) throws IdNotFoundException, NameNotFoundException, LocationNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		try {
			Optional<Movie> optional = this.getMovieById(id);
			if(optional.isEmpty())
			{
				throw new IdNotFoundException("record not found ");
			}
			else
			{
				movieRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<Movie> getMovieById(long id) throws IdNotFoundException, InvalidIdLengthException,
			InvalidNameException, NameNotFoundException, LocationNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}

	
}
