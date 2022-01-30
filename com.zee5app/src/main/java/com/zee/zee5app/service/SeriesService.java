package com.zee.zee5app.service;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;


public interface SeriesService {
	
	public String addSeries(Series series);
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidIdLengthException, NameNotFoundException;
	public Series[] getAllSeries() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException;
	public String modifySeries(String id, Series series) throws IdNotFoundException, NameNotFoundException;
	public String deleteSeries(String id) throws IdNotFoundException;
	
	public Optional<TreeSet<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException;
	
}
