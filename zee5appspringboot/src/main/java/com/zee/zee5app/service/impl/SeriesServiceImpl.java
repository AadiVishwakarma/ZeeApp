package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.Impl.SeriesRepositoryImpl;


@Service
public class SeriesServiceImpl implements SeriesService {

	public SeriesRepository seriesRepository;
//	private SeriesRepository seriesRepository = SeriesRepositoryImpl.getInstance();
//	private static SeriesService service;	
//	
//	public static SeriesService getInstance() throws IOException {
//		if(service == null)
//			service = new SeriesServiceImpl();
//		return service;
//	}
//	
//    private SeriesServiceImpl() throws IOException{
//		
//	}
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		return seriesRepository.addSeries(series);
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException,InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() throws InvalidIdLengthException,InvalidNameException, NameNotFoundException{
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeries();
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.modifySeries(id, series);
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.deleteSeries(id);
	}
	
	
	public Optional<TreeSet<Series>> getAllSeriesDetails() throws InvalidIdLengthException, InvalidNameException, NameNotFoundException{
		// TODO Auto-generated method stub
		return seriesRepository.getAllSeriesDetails();
	}

}
