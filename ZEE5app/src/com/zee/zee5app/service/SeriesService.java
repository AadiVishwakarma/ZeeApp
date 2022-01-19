package com.zee.zee5app.service;

import com.zee.zee5app.repository.SeriesRepository;

public class SeriesService {
private SeriesRepository seriesRepo = SeriesRepository.getInstance();
	
	private SeriesService()
	{
		
	}
	
	private static SeriesService seriesservice = null;
	
	public static SeriesService getInstance()
	{
		if(seriesservice==null)
		{
			seriesservice = new SeriesService();
		}
		return seriesservice;
	}
	
}
