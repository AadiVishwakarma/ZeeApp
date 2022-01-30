package com.zee.zee5app.dto;

import java.net.URL;

import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Movie implements Comparable<Movie>{
	

	public Movie(String movieName, float length, String id, String genre, String releaseDate, String trailer,
			String cast, int ageLimit, String language) {
		super();
		this.movieName = movieName;
		this.length = length;
		this.id=id ;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.trailer = trailer;
		this.Cast = cast;
		this.ageLimit = ageLimit;
		this.language = language;
	}

	@Setter(value=AccessLevel.NONE)
	private String movieName;
	
	private float length;
	private String id;
	private String genre;
	private String releaseDate;
	
	@Setter(value=AccessLevel.NONE)
	private String trailer;
	private String Cast;
	private int ageLimit;
	private String language;
	
	
	
	
	public void setMovieName(String movieName) throws NameNotFoundException {
		// TODO Auto-generated method stub
		if(movieName == null)
		{
			throw new NameNotFoundException("Movies Trailer Name not found");
		}
		this.movieName = movieName;
	}
	
	
	public void setTrailer(String trailer) throws LocationNotFoundException
	{
		if(trailer== null)
		{
			throw new LocationNotFoundException("Location of Movie Trailer not found");
		}
		this.trailer = trailer;
	}
	
	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}


	

	
}
