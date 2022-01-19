package com.zee.zee5app.service;
import com.zee.zee5app.dto.Series;

public interface SeriesService {
	
	public String addSeries(Series series);
	public Series getSeriesById(String id);
	public Series[] getAllSeries();

}
