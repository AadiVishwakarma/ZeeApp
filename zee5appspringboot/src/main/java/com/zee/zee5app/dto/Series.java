package com.zee.zee5app.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

@Data
@Getter
@Setter
@NoArgsConstructor

public class Series implements Comparable<Series>{
	
	@Setter(value=AccessLevel.NONE)
	private String seriesName;
	private float length;
	private String id;
	private String genre;
	private String releaseDate;
	
	@Setter(value = AccessLevel.NONE)
	private String trailer;
	private String Cast;
	private int ageLimit;
	private int NoOfEpisodes;
	private String language;
	
	
	
	
	public void setSeriesName(String seriesName) throws NameNotFoundException
	{
		if(seriesName == null)
		{
			throw new NameNotFoundException("Series Trailer Name not found");
		}
		this.seriesName = seriesName;
	}
	
	
	public void setTrailer(String trailer) throws LocationNotFoundException
	{
		if(trailer== null)
		{
			throw new LocationNotFoundException("Location of Series Trailer not found");
		}
		this.trailer = trailer;
	}
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}


	public Series(String seriesName, float length, String id, String genre, String releaseDate, String trailer,
			String cast, int ageLimit, int noOfEpisodes, String language) throws LocationNotFoundException {
		super();
		this.seriesName = seriesName;
		this.length = length;
		this.id = id;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.setTrailer(trailer) ;
		Cast = cast;
		this.ageLimit = ageLimit;
		NoOfEpisodes = noOfEpisodes;
		this.language = language;
	}


	
}
