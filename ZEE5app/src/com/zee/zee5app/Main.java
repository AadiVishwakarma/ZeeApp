package com.zee.zee5app;

import java.net.URL;
import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.MovieIdNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.SeriesIdNotFoundException;
import com.zee.zee5app.exception.SubscriptionIdNotFoundException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.impl.UserServiceImpl;
import com.zee.zee5app.service.impl.MovieServiceImpl;
import com.zee.zee5app.service.impl.SeriesServiceImpl;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		//Register regis = new Register(String id, String firstName,String lastName, String email,String password);
		/*
		Register regis;
		try {
			regis = new Register("wu68242","adiu424","sbwbjdwbdw", "123@gmail.com","12345");
		} catch (InvalidIdLengthException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		} catch (InvalidNameException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		System.out.println(regis);
		try {
			regis.setId("323");
		} catch (InvalidIdLengthException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			regis.setFirstName("asd");
		} catch (InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			regis.setLastName("bfiefb");
		} catch (InvalidNameException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			regis.setEmail("add@gmail.com");
		} catch (InvalidEmailException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			regis.setPassword("124");
		} catch (InvalidPasswordException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		*/
		
		//Create register object
		Register register = new Register();
		// Register : class name
		// register: reference which will refer your object - in stack memory
		// new : is used to create object - in heap memory
		// Register(): default constructor
		
		try {
			register.setFirstName("Abcjbcswsk");
			register.setLastName("sjcvscb");
		} catch (InvalidNameException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			register.setEmail("av@gmail.com");
		} catch (InvalidEmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			register.setPassword("Absjs1234");
		} catch (InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			register.setId("1286973");
		} catch (InvalidIdLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(register);
		System.out.println(register.toString());
		
		// whenever you will print the reference then it will call toString() method
		System.out.println(register.getEmail());
		
		
		
		
		
		
		//Create login object
		
		Login login  = new Login();
		
		login.setUserName("av23");
		login.setPassword("123");
		
		System.out.println(login);
		
		
		
		
		// we don't introduce private here to make it accessible
		//now this line can connect to different files with UserServiceImpl2 and so on
		UserService service = UserServiceImpl.getInstance();
		// main is consuming the service
		// if we even call this 100 times it will create only 1 object now
		
		
		
		for(int i =1; i<=20;i++) {
			Register register2 = new Register();
			
			try {
				register2.setId("67rr673"+i);
				register2.setFirstName("avdsdwsd"+i);
				register2.setFirstName("vishwaala"+i);
			} 
			catch(InvalidIdLengthException e)
			{
				e.printStackTrace();
			}
			catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e)
			{
				
			}
			catch(Throwable e)
			{
				
			}
			
			
			try {
				register2.setPassword("Abkdwfwf23");
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = service.addUser(register2);
			System.out.println(result);
			
		}
		
	
		
		//subscription
		SubscriptionService service2 = SubscriptionServiceImpl.getInstance();
		
		for(int i =1; i<=3;i++) {
			Subscription subscription = new Subscription();
			subscription.setId("sub00"+i);
			subscription.setAutoRenewal(null);
			subscription.setDateOfPurchase(null);
			subscription.setExpiryDate(null);
			subscription.setPackCountry(null);
			try {
				subscription.setSubscriptionAmount(650);
			} catch (InvalidAmountException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			subscription.setStatus(null);
			subscription.setType(null);
			String result = service2.addSubscription(subscription);
			System.out.println(result);
			
		}
		
		
		MovieService service3 = MovieServiceImpl.getInstance();
		for(int i =1; i<=5;i++) {
			Movie movie = new Movie();
			movie.setId("mov00"+i);
			try {
				movie.setMovieName("abc"+i);
			} catch (NameNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			movie.setAgeLimit(null);
			movie.setCast(new String[] {"hrk","abt","tdc","sdf"});
			movie.setGenre("action"+i);
			movie.setLength(null);
			movie.setReleaseDate(null);
			try {
				movie.setTrailer("https://www.google.com");
			} catch (LocationNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String result = service3.addMovie(movie);
			System.out.println(result);
			
		}
		

		SeriesService service4 = SeriesServiceImpl.getInstance();
		for(int i =1; i<=7;i++) {
			Series series = new Series();
			series.setId("sr00"+i);
			try {
				series.setSeriesName("xyz"+i);
			} catch (NameNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			series.setAgeLimit(null);
			series.setCast(new String[] {"ytd","efd","gfh","trd"});
			series.setGenre("thriller"+i);
			series.setLength(null);
			series.setReleaseDate(null);
			try {
				series.setTrailer("www.google.com");
			} catch (LocationNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String result = service4.addSeries(series);
			System.out.println(result);
			
		}
		
		for (Subscription subscription : service2.getAllSubscriptions()) {
			if(subscription!=null)
			 System.out.println(subscription);
					
		}
		
		for (Movie movie : service3.getAllMovies()) {
			if(movie!=null)
			 System.out.println(movie);
					
		}
		
		for (Series series : service4.getAllSeries()) {
			if(series!=null)
			 System.out.println(series);
					
		}
		
		//this gives an error now coz its an interface thing
		//UserRepository repository = new UserRepository();
		
		//UserRepository repository = null;
	
		
		
		
		Optional<Register> optional;
		try {
		optional = service.getUserById("ab00001") ;
		if(optional.isPresent())
		{
			System.out.println("getUserById "+optional.get());
		}
		else
		{
			System.out.println("id not found/available");
		}
		}
		catch(IdNotFoundException e)
		{
			e.printStackTrace();
		}
		
		service.getAllUserDetails().forEach(e->System.out.println(e));	
		
		
		
		//getsubscription by id
		Optional<Subscription> optionalsubscription ;
		try {
			optionalsubscription = service2.getSubscriptionById("ab00001345");
			if(optionalsubscription.isPresent())
			{
				System.out.println("getSubscriptionById "+optionalsubscription.get());
			}
			else
			{
				System.out.println("subscription id not found");
			}
		} catch (SubscriptionIdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		//getSeriesbyid
		Optional<Series> optionalSeries;
		try {
			optionalSeries = service4.getSeriesById("ab00001");
			
			if(optionalSeries.isPresent())
			{
				System.out.println("getSeriesById : "+optionalSeries.get());
			}
			else
			{
				System.out.println("Series id not found or not available");
			}
			
		} catch (SeriesIdNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		
		//getmoviesby id
		Optional<Movie> optionalMovies;
		try {
			optionalMovies = service3.getMovieById("ab00001");
			
			if(optionalMovies.isPresent())
			{
				System.out.println("getMoviebyId : "+optionalMovies.get());
			}
			else
			{
				System.out.println("Movie id not found or not available");
			}
		} catch (MovieIdNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

}
