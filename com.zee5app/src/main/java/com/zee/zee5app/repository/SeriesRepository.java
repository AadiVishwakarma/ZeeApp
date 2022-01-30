package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;



public interface SeriesRepository {
	
	public String addSeries(Series series); 
	public String deleteSeries(String id) throws IdNotFoundException;
	public String modifySeries(String id, Series series) throws IdNotFoundException, NameNotFoundException;
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, NameNotFoundException;
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException;
	public Optional<TreeSet<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException;
	

}
