package com.zee.zee5app.repository.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SeriesIdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {

	//private Series[] seriess = new Series[10];
	//private static int count = -1;
	
	private TreeSet<Series> treeSet = new TreeSet<>();
	
	
	private static SeriesRepository seriesrepository;
	public static SeriesRepository getInstance() {
		if(seriesrepository==null)
			seriesrepository = new SeriesRepositoryImpl();
		return seriesrepository;
	}
	
	private SeriesRepositoryImpl() {
		
	}
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		boolean result = this.treeSet.add(series);
		if(result)
		{
			return "series added successfully";
		}
		else
		{
			return "failed to add series";
		}
	}

	@Override
	public String deleteSeries(String id) throws SeriesIdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Series> optional = this.getSeriesById(id);
		
		if(optional.isPresent())
		{
			boolean result = treeSet.remove(optional.get());
			if(result)
			{
				return "series successfully deleted";
			}
			else
			{
				return "series failed to delete";
			}
		}

		return "fail";
	}

	@Override
	public String modifySeries(String id, Series series) throws SeriesIdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		String result = this.deleteSeries(id);
		if(result=="Failed")
			return "Failed to delete series";
		result = this.addSeries(series);
		if(result=="Fail")
			return "Failed to add Series";
		return "Series Modified";
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws SeriesIdNotFoundException{
		// TODO Auto-generated method stub
		Series series2 = null;
		for (Series series : treeSet) {
			if(series.getId().equals(id))
			{
				//return Optional.of(subscription);
				series2 = series;
			}
		}
		return Optional.ofNullable(Optional.of(series2).orElseThrow(()-> new SeriesIdNotFoundException("series id not found")));
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		Series series[] = new Series[treeSet.size()];
		
		return treeSet.toArray(series);
	}
	
	@Override
	public TreeSet<Series> getAllSeriesDetails()
	{
		return treeSet;
	}

}
