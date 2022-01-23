package com.zee.zee5app.dto;

import java.net.URL;

import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Movie implements Comparable<Movie>{
	
	@Setter(value=AccessLevel.NONE)
	private String movieName;
	
	private String length;
	private String id;
	private String genre;
	private String releaseDate;
	
	@Setter(value=AccessLevel.NONE)
	private String trailer;
	private String Cast[];
	private String ageLimit;
	
	
	
	
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
