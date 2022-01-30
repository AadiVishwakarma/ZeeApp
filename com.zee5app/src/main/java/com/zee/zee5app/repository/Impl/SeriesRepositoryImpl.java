package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import com.mysql.cj.xdevapi.SelectStatement;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

public class SeriesRepositoryImpl implements SeriesRepository {

	//private Series[] seriess = new Series[10];
	//private static int count = -1;
	
	DBUtils dbUtils = DBUtils.getInstance();
	
	private TreeSet<Series> treeSet = new TreeSet<>();
	
	
	private static SeriesRepository seriesrepository;
	public static SeriesRepository getInstance() throws IOException {
		if(seriesrepository==null)
			seriesrepository = new SeriesRepositoryImpl();
		return seriesrepository;
	}
	
	private SeriesRepositoryImpl() throws  IOException{
		
	}
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
//		boolean result = this.treeSet.add(series);
//		if(result)
//		{
//			return "series added successfully";
//		}
//		else
//		{
//			return "failed to add series";
//		}
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertStatement = "Insert into Series"+"(trailer,releasedateseries,cast,genre, length, language,noofepisodes,seriesname,agelimit,seriesId)"+"values(?,?,?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			
			preparedStatement.setString(1,series.getTrailer());
			preparedStatement.setString(2,series.getReleaseDate());
			preparedStatement.setString(3,series.getCast());
			preparedStatement.setString(4,series.getGenre());
			preparedStatement.setFloat(5,series.getLength());
			preparedStatement.setString(6,series.getLanguage());
			preparedStatement.setInt(7,series.getNoOfEpisodes());
			preparedStatement.setString(8,series.getSeriesName());
			preparedStatement.setInt(9,series.getAgeLimit());
			preparedStatement.setString(10,series.getId());
			
			
			int result =preparedStatement.executeUpdate();
			
			if(result>0) 
			{
					connection.commit();
					return "Success!";
			}
			else
				{
					connection.rollback();
					return "Fail";
				}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		finally {
			// closure work 
			// closing the connection
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException{
		// TODO Auto-generated method stub
//		Optional<Series> optional = this.getSeriesById(id);
//		
//		if(optional.isPresent())
//		{
//			boolean result = treeSet.remove(optional.get());
//			if(result)
//			{
//				return "series successfully deleted";
//			}
//			else
//			{
//				return "series failed to delete";
//			}
//		}
//
//		return "fail";
		
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from series where seriesId=?";
	
		
		// Connection object
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
					
			int result =preparedStatement.executeUpdate();
		
			if(result>0) {
				connection.commit();
				return "Series record deleted"	;
			}
			else {
				connection.rollback();
				return "fail to delete series";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		finally {
			// closure work 
			// closing the connection
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
//		String result = this.deleteSeries(id);
//		if(result=="Failed")
//			return "Failed to delete series";
//		result = this.addSeries(series);
//		if(result=="Fail")
//			return "Failed to add Series";
//		return "Series Modified";
		
		Connection connection;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE series"+" SET seriesId=? , trailer=?, releasedateSeries=? , cast=? , genre=? , length=? , language=? , NoOfEpisodes=? , seriesName=? , ageLimit=? , seriesId=?"+ "WHERE(seriesId=?)";
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			
			preparedStatement.setString(1,series.getTrailer());
			preparedStatement.setString(2,series.getReleaseDate());
			preparedStatement.setString(3,series.getCast());
			preparedStatement.setString(4,series.getGenre());
			preparedStatement.setFloat(5,series.getLength());
			preparedStatement.setString(6,series.getLanguage());
			preparedStatement.setInt(7,series.getNoOfEpisodes());
			preparedStatement.setString(8,series.getSeriesName());
			preparedStatement.setInt(9,series.getAgeLimit());
			preparedStatement.setString(10,series.getId());
		
		int result = preparedStatement.executeUpdate();
		if(result>0)
		{
			connection.commit();
			return "success";
		}
		else {
			connection.rollback();
			return "fail";
		}
		} catch(SQLException e)
		{
			e.printStackTrace();
			try {
			connection.rollback();
			}catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
		
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException, NameNotFoundException{
		// TODO Auto-generated method stub
//		Series series2 = null;
//		for (Series series : treeSet) {
//			if(series.getId().equals(id))
//			{
//				//return Optional.of(subscription);
//				series2 = series;
//			}
//		}
//		return Optional.ofNullable(Optional.of(series2).orElseThrow(()-> new IdNotFoundException("series id not found")));
		
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM series WHERE seriesId=?";
	
		
		// Connection object
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				Series series = new Series();
				series.setId(resultSet.getString("seriesId"));
				series.setSeriesName(resultSet.getString("name"));
				series.setAgeLimit(resultSet.getInt("ageLimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenre(resultSet.getString("genre"));
				series.setLength(resultSet.getFloat("length"));
				series.setReleaseDate(resultSet.getString("releaseDate"));
				series.setLanguage(resultSet.getString("language"));
				series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				return Optional.of(series);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
		
		
	}

	@Override
	public Series[] getAllSeries() throws InvalidIdLengthException,InvalidNameException, NameNotFoundException{
		// TODO Auto-generated method stub
//		Series series[] = new Series[treeSet.size()];
//		return treeSet.toArray(series);
		Optional<TreeSet<Series>> optional = getAllSeriesDetails();
		
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			TreeSet<Series> list=optional.get();
			Series[] series =new Series[list.size()];
			return list.toArray(series);
		}
	}
	

	@Override
	public Optional<TreeSet<Series>> getAllSeriesDetails() throws InvalidIdLengthException,InvalidNameException, NameNotFoundException
	{
		//return treeSet;
		Connection connection;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		TreeSet<Series>  treeSet = new TreeSet<Series>();
		
		String selectStatement = "SELECT * FROM series ";
		
		connection = dbUtils.getConnection();
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet =  preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				// next method is used to traverse the RS
				/// initially RS will be places just above the 1st rec.
				// when u will call 1st time rs will retrieve the 1st rec & 
				// it will refer the 2nd one.
				Series series = new Series();
				series.setId(resultSet.getString("seriesId"));
				series.setSeriesName(resultSet.getString("name"));
				series.setAgeLimit(resultSet.getInt("ageLimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenre(resultSet.getString("genre"));
				series.setLength(resultSet.getFloat("length"));
				series.setReleaseDate(resultSet.getString("releaseDate"));
				series.setLanguage(resultSet.getString("language"));
				series.setNoOfEpisodes(resultSet.getInt("noOfEpisodes"));
				treeSet.add(series);
				
				
			}
			return Optional.ofNullable(null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return Optional.empty();
	}

}
