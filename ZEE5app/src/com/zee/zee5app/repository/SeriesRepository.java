package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;


public interface SeriesRepository {
	
	public String addSeries(Series series); 
	public String deleteSeries(String id);
	public String modifySeries(String id, Series series);
	public Series getSeriesById(String id);
	public Series[] getAllSeries();

}
