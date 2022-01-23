package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SeriesIdNotFoundException;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.Impl.SeriesRepositoryImpl;

public class SeriesServiceImpl implements SeriesService {

	private SeriesRepository seriesRepository = SeriesRepositoryImpl.getInstance();
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
		return this.seriesRepository.addSeries(series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws SeriesIdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeries();
	}

	@Override
	public String modifySeries(String id, Series series) throws SeriesIdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.modifySeries(id, series);
	}

	@Override
	public String deleteSeries(String id) throws SeriesIdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeries(id);
	}
	
	
	public TreeSet<Series> getAllSeriesDetails() {
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeriesDetails();
	}

}
