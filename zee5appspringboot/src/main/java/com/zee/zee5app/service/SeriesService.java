package com.zee.zee5app.service;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;


public interface SeriesService {
	
	public Series addSeries(Series series);
	public Optional<Series> getSeriesById(long id) throws IdNotFoundException, InvalidIdLengthException, InvalidIdLengthException, NameNotFoundException;
	public Optional<List<Series>> getAllSeries() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException;
	public String modifySeries(Long id, Series series) throws IdNotFoundException, NameNotFoundException;
	public String deleteSeries(Long id) throws IdNotFoundException, NameNotFoundException;
	
	public Optional<List<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException;
	
}
