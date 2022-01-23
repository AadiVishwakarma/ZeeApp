package com.zee.zee5app.service;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SeriesIdNotFoundException;

public interface SeriesService {
	
	public String addSeries(Series series);
	public Optional<Series> getSeriesById(String id) throws SeriesIdNotFoundException;
	public Series[] getAllSeries();
	public String modifySeries(String id, Series series) throws SeriesIdNotFoundException, NameNotFoundException;
	public String deleteSeries(String id) throws SeriesIdNotFoundException;
	
	public TreeSet<Series> getAllSeriesDetails();
	
}
