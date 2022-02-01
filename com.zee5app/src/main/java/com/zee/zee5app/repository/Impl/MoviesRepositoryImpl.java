package com.zee.zee5app.repository.Impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.SubscriptionRepository;
import com.zee.zee5app.utils.DBUtils;

@Repository
public class MoviesRepositoryImpl implements MovieRepository {

	//private Movie[] movies = new Movie[10];
	//private static int count = -1;
	DBUtils dbUtils = DBUtils.getInstance();
	
	private HashSet<Movie> hashSet = new HashSet<>();
	
	@Autowired
	DataSource dataSource;
	static private MovieRepository movieRepository=null;
//	private static MovieRepository movieRepository;
	public static MovieRepository getInstance() throws IOException {
		if(movieRepository==null)
			movieRepository = new MoviesRepositoryImpl();
		return movieRepository;
	}
	
	private MoviesRepositoryImpl() throws IOException {
		
	}
	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
//		boolean result = this.hashSet.add(movie);
//		if(result)
//		{
//			return "movie added successfully";
//		}
//		else
//		{
//			return "failed to add movie";
//		}
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		String insertStatement = "Insert into Movies"+"(movieId,moviesname,agelimit,cast,genre, length,trailer,releasedatemovie,language)"+"values(?,?,?,?,?,?,?,?,?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			
			preparedStatement.setString(1,movie.getId());
			preparedStatement.setString(2,movie.getMovieName());
			preparedStatement.setInt(3,movie.getAgeLimit());
			preparedStatement.setString(4,movie.getCast());
			preparedStatement.setString(5,movie.getGenre());
			preparedStatement.setFloat(6,movie.getLength());
			preparedStatement.setString(7,movie.getTrailer());
			preparedStatement.setString(8,movie.getReleaseDate());
			preparedStatement.setString(9,movie.getLanguage());
			
			
			
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
		
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
//		Optional <Movie> optional = this.getMovieById(id);
//		
//		if(optional.isPresent())
//		{
//			boolean result = hashSet.remove(optional.get());
//			if(result)
//			{
//				return "Movie successfully deleted";
//			}
//			else
//			{
//				return "Movie failed to delete";
//			}
//		}
//
//		return "fail";
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		String deleteStatement = "DELETE FROM movies WHERE movieId=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "Success";
			}
			else {
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
			return "Fail";
		}
		
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException,NameNotFoundException {
		// TODO Auto-generated method stub
//		String result = this.deleteMovie(id);
//		if(result=="Failed")
//			return "Failed to delete movie";
//		result = this.addMovie(movie);
//		if(result=="Fail")
//			return "Failed to add movie";
//		return "movie details modified";
		Connection connection = null;
		PreparedStatement preparedStatement;
		String updateStatement = "UPDATE movies"+" SET movieId=? ,moviesname=? ,agelimit = ? ,cast = ? , genre = ? , length = ?, trailer = ?, releasedatemovie = ?, language = ?"+ "WHERE(movieId=?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			
			preparedStatement.setString(1,movie.getId());
			preparedStatement.setString(2,movie.getMovieName());
			preparedStatement.setInt(3,movie.getAgeLimit());
			preparedStatement.setString(4,movie.getCast());
			preparedStatement.setString(5,movie.getGenre());
			preparedStatement.setFloat(6,movie.getLength());
			preparedStatement.setString(7,movie.getTrailer());
			preparedStatement.setString(8,movie.getReleaseDate());
			preparedStatement.setString(9,movie.getLanguage());
		
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
		
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, NameNotFoundException, LocationNotFoundException{
		// TODO Auto-generated method stub
//		Movie movie2 = null;
//		for (Movie movie : hashSet) {
//			if(movie.getId().equals(id))
//			{
//				//return Optional.of(subscription);
//				movie2 = movie;
//			}
//		}
//		return Optional.ofNullable(Optional.of(movie2).orElseThrow(()-> new IdNotFoundException("movie id not found")));
		
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		
		String selectStatement = "SELECT * FROM series WHERE seriesId=?";
	
		
		// Connection object
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				Movie movie = new Movie();
				movie.setId(resultSet.getString("movieId"));
				movie.setMovieName(resultSet.getString("movieName"));
				movie.setAgeLimit(resultSet.getInt("ageLimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setReleaseDate(resultSet.getString("releaseDate"));
				movie.setLanguage(resultSet.getString("language"));
				return Optional.of(movie);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.empty();
	}

	@Override
	public Movie[] getAllMovie() throws LocationNotFoundException, NameNotFoundException {
		// TODO Auto-generated method stub
//		Movie movie[] = new Movie[hashSet.size()];
//		return hashSet.toArray(movie);
		Optional<HashSet<Movie>> optional = getAllMovieDetails();
		if(optional.isEmpty())
			return null;
		else {
			HashSet<Movie> list = optional.get();
			Movie[] movies = new Movie[list.size()];
			return list.toArray(movies);
		}
		
	}
	
	@Override
	public Optional<HashSet<Movie>> getAllMovieDetails() throws LocationNotFoundException, NameNotFoundException
	{
		Connection connection=null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		HashSet<Movie> arrayList = new HashSet<Movie>();
		
		String selectStatement = "SELECT * FROM movies";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setId(resultSet.getString("movieId"));
				movie.setMovieName(resultSet.getString("movieName"));
				movie.setAgeLimit(resultSet.getInt("ageLimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenre(resultSet.getString("genre"));
				movie.setLength(resultSet.getFloat("length"));
				movie.setTrailer(resultSet.getString("trailer"));
				movie.setReleaseDate(resultSet.getString("releaseDate"));
				movie.setLanguage(resultSet.getString("language"));
				arrayList.add(movie);
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.empty();
	}

}
