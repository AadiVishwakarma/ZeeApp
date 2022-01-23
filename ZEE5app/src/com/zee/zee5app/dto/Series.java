package com.zee.zee5app.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;

@Data
public class Series implements Comparable<Series>{
	
	@Setter(value=AccessLevel.NONE)
	private String seriesName;
	private String length;
	private String id;
	private String genre;
	private String releaseDate;
	
	@Setter(value = AccessLevel.NONE)
	private String trailer;
	private String Cast[];
	private String ageLimit;
	
	
	
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
}
