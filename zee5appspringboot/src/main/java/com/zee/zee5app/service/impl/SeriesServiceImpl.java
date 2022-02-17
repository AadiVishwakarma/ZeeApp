package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.repository.SeriesRepository;

@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesRepository seriesRepository;

	
	@Override
	public Series addSeries(Series series) {
		// TODO Auto-generated method stub
		Series series2 = seriesRepository.save(series);
		
		if(series2 != null)
		{
			return series2;
		}
		else
		{
			return null;
		}
	}



	@Override
	public Optional<List<Series>> getAllSeries()  {
		// TODO Auto-generated method stub
//		List<Series> list = seriesRepository.findAll();
//		Series[] array = new Series[list.size()];
//		return list.toArray(array);
		return Optional.ofNullable(seriesRepository.findAll());
	}


	@Override
	public String modifySeries(Long id, Series series) throws IdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Optional<List<Series>> getAllSeriesDetails()
			throws InvalidIdLengthException, InvalidNameException, NameNotFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
	}


	@Override
	public Optional<Series> getSeriesById(long id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidIdLengthException, NameNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
	}



	@Override
	public String deleteSeries(Long id) throws IdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Series> optional = this.getSeriesById(id);
			if(optional.isEmpty())
			{
				throw new IdNotFoundException("record not found ");
			}
			else
			{
				seriesRepository.deleteById(id);
				return "success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	
}
