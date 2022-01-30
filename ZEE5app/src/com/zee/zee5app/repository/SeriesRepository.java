package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SeriesIdNotFoundException;


public interface SeriesRepository {
	
	public String addSeries(Series series); 
	public String deleteSeries(String id) throws SeriesIdNotFoundException;
	public String modifySeries(String id, Series series) throws SeriesIdNotFoundException, NameNotFoundException;
	public Optional<Series> getSeriesById(String id) throws SeriesIdNotFoundException;
	public Series[] getAllSeries();
	public TreeSet<Series> getAllSeriesDetails();
	

}
