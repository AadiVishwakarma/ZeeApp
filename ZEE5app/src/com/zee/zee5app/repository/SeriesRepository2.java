package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;

public class SeriesRepository {
	private Series[] movie = new Series[10];
	
	private SeriesRepository()
	{
		
	}
	
	public static SeriesRepository seriesRepository;
	public static SeriesRepository getInstance()
	{
		if(seriesRepository == null)
			seriesRepository = new SeriesRepository();
		return seriesRepository;
	}
}
