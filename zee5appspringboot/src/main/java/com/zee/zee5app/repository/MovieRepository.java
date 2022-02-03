package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

	Boolean existsByName(String name);
	
	Optional<Movie> findByNameAndLanguage(String name,String langugae);
	
	Optional<Movie> findByName(String name);
	
	Optional<Movie> findByNameAndReleaseDate(String name,String releaseDate);
	
	Optional<Movie> findByCast(String cast);
}
