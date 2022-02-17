package com.zee.zee5app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.MovieService;
@CrossOrigin("*")
@RestController

@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@PostMapping("/addMovie")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addMovie(@Valid @RequestBody Movie movie) throws AlreadyExistsException
	{
		//try {
		Movie result =	movieService.addMovie(movie);
		System.out.println(result);
		return ResponseEntity.status(201).body(result);
		
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getMovieById(@PathVariable("id") long id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, NameNotFoundException, LocationNotFoundException {
		Optional<Movie> movieDetails = movieService.getMovieById(id);
		return ResponseEntity.status(200).body(movieDetails.get());
	}

	// get all movies
	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> getAllMovies() throws InvalidIdLengthException, InvalidNameException, LocationNotFoundException, NameNotFoundException {
		Optional<List<Movie>> optional = movieService.getAllMovies();
		if (optional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No movies found");
		}
		return ResponseEntity.status(200).body(optional.get());	
	}
}
