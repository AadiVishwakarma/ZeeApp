package com.zee.zee5app;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Zee5appspringbootApplication.class, args);
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		
//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//		System.out.println(dataSource != null);
		
	//	UserService userService = applicationContext.getBean(UserService.class);
////		//UserRepository userRepository  = applicationContext.getBean(UserRepository.class);
////		Register register;
////		register = new Register("aditya001","Aditya","Vishwakarma","aditya01@gmail.com","adi1234",null);
////		register.setContactNumber(new BigDecimal("9813973123"));
////		
////		System.out.println(userService.addUser(register));
		
//		System.out.println("Add User");
//		for (int i = 1; i <= 5; i++) {
//			Register register = new Register("Reg00"+i, "Aditya"+i, "Vishwakarma"+i, "Adi"+i+"@gmail.com", "Adi00@"+i, "9876543210"+i);
//			System.out.println(userService.addUser(register) + " " + i);
//		}
//		System.out.println();
//		
//		System.out.println("Get User by Id");
//		try {
//			System.out.println(userService.getUserById("reg001").get());
//		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException
//				| InvalidPasswordException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Get All UserDetails: ");
//		try {
//			userService.getAllUserDetails().get().forEach(e->System.out.println(e));
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Delete Record by Id");
//		try {
//			System.out.println(userService.deleteUserById("reg002"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("All UserDetails in array");
//		try {
//			for (Register register : userService.getAllUsers()) {
//				System.out.println(register);
//			}
//		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException
//				| InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		
		
		
//		//Subscription
//		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
//		System.out.println("Add Subscription");
//		for (int i = 1; i <= 5; i++) {
//			Subscription subscription = new Subscription("sub00"+i, "2022-04-0"+i, "2025-10-0"+i, 85000+i, "UPI"+i, "yearly"+i, "active"+i, "yes"+i, "reg000"+i);
//			System.out.println(subscriptionService.addSubscription(subscription) + " " + i);
//		}
//		System.out.println();
//		
//		System.out.println("Get Subscription by Id");
//		try {
//			System.out.println(subscriptionService.getSubscriptionById("sub002").get());
//		} catch (IdNotFoundException | InvalidAmountException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Get All SubscriptionDetails: ");
//		try {
//			subscriptionService.getAllSubscriptionDetails().get().forEach(e->System.out.println(e));
//		} catch (InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Delete Subscription by Id");
//		try {
//			System.out.println(subscriptionService.deleteSubscription("sub003"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("SubscriptionDetails in array :");
//		try {
//			for (Subscription subscription : subscriptionService.getAllSubscriptions()) {
//				System.out.println(subscription);
//			}
//		} catch (InvalidAmountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
		
		
		
//		//series table
//		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
//		System.out.println("Add Series");
//		for (int i = 1; i <= 5; i++) {
//			Series series = new Series("ser00"+i, "SeriesName : "+i,"genre : "+i, "2029-7-0"+i, "google series "+i, "cast : "+i, 18+i,4+i, "Language"+i);
//			System.out.println(seriesService.addSeries(series) + " " + i);
//		}
//		System.out.println();
//		
//		System.out.println("Get Series by Id");
//		try {
//			System.out.println(seriesService.getSeriesById("ser002").get());
//		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("All Series Details:");
//		try {
//			seriesService.getAllSeriesDetails().get().forEach(e->System.out.println(e));
//		} catch (InvalidIdLengthException | InvalidNameException | NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Delete Series by Id");
//		try {
//			System.out.println(seriesService.deleteSeries("ser003"));
//		} catch (IdNotFoundException | NameNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("series details in array: ");
//		try {
//			for (Series series : seriesService.getAllSeries()) {
//				System.out.println(series);
//			}
//		} catch (InvalidIdLengthException | InvalidNameException | NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
		
		
		
//		//movie table
//		MovieService movieService = applicationContext.getBean(MovieService.class);
//		System.out.println("Add Movie");
//		for (int i = 1; i <= 5; i++) {
//			Movie movie = new Movie("mov00"+i, "MovieName"+i, 5+i, "Genre"+i, "2026-05-0"+i,"google link :" +i,"cast"+i, 50+i, "Language"+i);
//			System.out.println(movieService.addMovie(movie) + " " + i);
//		}
//		System.out.println();
//		
//		System.out.println("Get Movie by Id");
//		try {
//			System.out.println(movieService.getMovieById("mov002").get());
//		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | NameNotFoundException
//				| LocationNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Movie Details");
//		try {
//			movieService.getAllMovieDetails().get().forEach(e->System.out.println(e));
//		} catch (InvalidIdLengthException | InvalidNameException | LocationNotFoundException
//				| NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Delete Movie by Id");
//		try {
//			System.out.println(movieService.deleteMovie("mov003"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (LocationNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("Movie Details in array :");
//		try {
//			for (Movie movie : movieService.getAllMovies()) {
//				System.out.println(movie);
//			}
//		} catch (InvalidIdLengthException | InvalidNameException | LocationNotFoundException
//				| NameNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
		
		
//		//episode
//		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
//		System.out.println("Add Episode");
//		for (int i = 1; i <= 5; i++) {
//			Episode episode = new Episode("epi00"+i, "ser00"+i, "EpisodeName"+i, 18+i, "google link"+i, "youtube link" +i);
//			System.out.println(episodeService.addEpisode(episode) + " " + i);
//		}
//		System.out.println();
//		
//		System.out.println("Get Episode by Id");
//		System.out.println(episodeService.getEpisodeById("epi002").get());
//		System.out.println();
//		
//		System.out.println("All Episode Details :");
//		episodeService.getAllEpisodeDetails().get().forEach(e->System.out.println(e));
//		System.out.println();
//		
//		System.out.println("Delete Episode by Id");
//		try {
//			System.out.println(episodeService.deleteEpisode("epi003"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//		
//		System.out.println("episode details in array");
//		for (Episode episode : episodeService.getAllEpisode()) {
//			System.out.println(episode);
//		}
//		System.out.println();
		
		
//		//login table
//		LoginService loginService = applicationContext.getBean(LoginService.class);
//		System.out.println("Add Login");
//		for (int i = 1; i <= 5; i++) {
//			Login login = new Login("aditya"+i, "aditya77"+i, "reg00"+i, ROLE.ROLE_USER);
//			System.out.println(loginService.addCredentials(login) + " " + i);
//		}
//		System.out.println();
//		
//		System.out.println("delete login");
//		try {
//			System.out.println(loginService.deleteCredentials("aditya2"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println();
//		
		applicationContext.close();
	}

}
