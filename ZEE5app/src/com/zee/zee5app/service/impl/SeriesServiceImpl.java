package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.Impl.SeriesRepositoryImpl;

public class SeriesServiceImpl implements SeriesService {

	private SeriesRepository repository = SeriesRepositoryImpl.getInstance();
	private static SeriesService service;	
	
	public static SeriesService getInstance() {
		if(service == null)
			service = new SeriesServiceImpl();
		return service;
	}
	
    private SeriesServiceImpl() {
		
	}
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return this.repository.addSeries(series);
	}

	@Override
	public Series getSeriesById(String id) {
		// TODO Auto-generated method stub
		return this.repository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return repository.getAllSeries();
	}

}
