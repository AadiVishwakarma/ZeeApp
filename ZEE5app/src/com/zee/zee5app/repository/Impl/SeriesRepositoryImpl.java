package com.zee.zee5app.repository.Impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {

	private Series[] seriess = new Series[10];
	private static int count = -1;
	
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
		if(count == seriess.length-1) {
			Series temp[] = new Series[seriess.length*4];
			System.arraycopy(series, 0, temp, 0, seriess.length);
			seriess = temp;
			seriess[++count] = series;
			
			return "Success4";
		}
		seriess[++count] = series;
		return "Success4";
	}

	@Override
	public String deleteSeries(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifySeries(String id, Series series) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Series getSeriesById(String id) {
		// TODO Auto-generated method stub
		for (Series series : seriess) {
			if(series!=null && series.getId().equals(id))
				return series;
		}
		return null;
	}

	@Override
	public Series[] getAllSeries() {
		// TODO Auto-generated method stub
		return seriess;
	}

}
