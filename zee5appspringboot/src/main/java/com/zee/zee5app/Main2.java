//package com.zee.zee5app;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.zee.zee5app.dto.EROLE;
//import com.zee.zee5app.dto.Episode;
//import com.zee.zee5app.dto.Movie;
//import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.dto.Role;
//import com.zee.zee5app.dto.Series;
//import com.zee.zee5app.dto.Subscription;
//import com.zee.zee5app.exception.AlreadyExistsException;
//import com.zee.zee5app.exception.IdNotFoundException;
//import com.zee.zee5app.exception.InvalidIdLengthException;
//import com.zee.zee5app.exception.InvalidNameException;
//import com.zee.zee5app.exception.LocationNotFoundException;
//import com.zee.zee5app.exception.NameNotFoundException;
//import com.zee.zee5app.repository.MovieRepository;
//import com.zee.zee5app.repository.RoleRepository;
//import com.zee.zee5app.repository.SeriesRepository;
//import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.service.EpisodeService;
//import com.zee.zee5app.service.MovieService;
//import com.zee.zee5app.service.RoleService;
//import com.zee.zee5app.service.SeriesService;
//import com.zee.zee5app.service.SubscriptionService;
//import com.zee.zee5app.service.UserService;
//
//@SpringBootApplication
//public class Main2 {
//
//	public static void main(String[] args) throws AlreadyExistsException {
//		// TODO Auto-generated method stub
//
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class, args);
////		UserService userService = applicationContext.getBean(UserService.class);
////		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
//		
//		//System.out.println(userRepository.existsByEmailAndContactNumber("Adi3@gmail.com","98765432103"));
//		//System.out.println(userService.addUser("aditya1"));
//		
//		
////		MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
////		System.out.println(movieRepository.findByNameAndLanguage("MovieName4","language4"));
////		System.out.println(movieRepository.findByName("MovieName4"));
////		System.out.println(movieRepository.findByNameAndReleaseDate("MovieName4","2026-05-04"));
////		System.out.println(movieRepository.findByCast("cast4"));
//		
////		SeriesRepository seriesRepository = applicationContext.getBean(SeriesRepository.class);
////		System.out.println(seriesRepository.findByNameAndLanguage("SeriesName : 4","Language4"));
//		
//		
//		
////		Role role = new Role();
////		role.setRoleName(EROLE.ROLE_ADMIN);
////		
////		Role role2 = new Role();
////		role2.setRoleName(EROLE.ROLE_USER);
//		
////		RoleService roleService = applicationContext.getBean(RoleService.class);
////		System.out.println(roleService.addRole(role));
////		System.out.println(roleService.addRole(role2));
////		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//
////		Register register;
////		System.out.println("Add User");
////		register = new Register("adi0014", "Aditya", "Vishwakarma", "Adi14@gmail.com", "Adi00@", "9876543210",null);
////		Set<Role> roles = new HashSet<>();
////		roles.add(roleRepository.findById(1).get());
////		roles.add(roleRepository.findById(2).get());
////		register.setRoles(roles);
////		System.out.println(userService.addUser(register));
//		
////		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
////		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
////		Series series1 = new Series("ser001", "SeriesName1","genre1", "2029-7-0", "google series ", "cast : ", 18,4, "Language1", null);
////		Series series2 = new Series("ser002", "SeriesName2","genre2", "2029-7-0", "google series ", "cast : ", 18,4, "Language2", null);
//////		System.out.println(seriesService.addSeries(series1)) ;
//////		System.out.println(seriesService.addSeries(series2) );
////		Episode episode = new Episode("ep-01", "episode1", 120, "drive", "youtube", series1);
////		episodeService.addEpisode(episode);
//		
//		
////		UserService userService = applicationContext.getBean(UserService.class);
////		SubscriptionService subscriptionService = applicationContext.getBean(SubscriptionService.class);
////		Register register1 = new Register("checkreg1", "Aditya", "Vishwakarma", "Adi@gmail.com", "Adi001", "98765432101",null,null);
////		Set<Role> roles = new HashSet<>();
////		roles.add(roleRepository.findById(1).get());
////		register1.setRoles(roles);
////		System.out.println(userService.addUser(register1)) ;
////		
////		
////		Subscription subscription = new Subscription("subs1", "2026-05-09", "2027-05-09", 400, "UPI", "active", "monthly", "yes", "Id1", register1);
////		subscriptionService.addSubscription(subscription);
//		
//		
//		
//		/*check 
//		
//		MovieService movieService = applicationContext.getBean(MovieService.class);
//		FileUtils fileUtils = applicationContext.getBean(FileUtils.class);
//		String src = "C:\\Users\\rithwik.chithreddy\\Downloads\\pushpa trailer.mp4";
//		String des = "C:\\Users\\rithwik.chithreddy\\Downloads\\movieStore\\pushpa trailer.mp4";
//		
//		Movie movie = new Movie("mov0001", "Pushpa", 18, "Allu Arjun", "Action", 250, null, "2022-12-15", "Hindi");
//		movie.setTrailer(des);
//		
//		String result = movieService.addMovie(movie);
//		if (result.equals("Success")) {
//			File file = new File(src);
//			byte[] data = null;
//			try {
//				data = fileUtils.readFile(file);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			fileUtils.writeFile(data, des);
//		}
//		
//		applicationContext.close();
//	}
//		
//		
//		*/
//		
//		
//		
//		
////		MovieService movieService = applicationContext.getBean(MovieService.class);
////		
////		//3rd case
////		Movie movie = new Movie();
////		movie.setId("mov001");
////		movie.setAgeLimit(18);
////		movie.setCast("allu arjun");
////		movie.setLanguage("hindi");
////		movie.setLength(250);
////		movie.setName("pushpa");
////		movie.setGenre("action");
////		
////		FileInputStream fileInputStream = null;
////		FileOutputStream fileOutputStream =null;
////		try {
////			fileInputStream = new FileInputStream("D:\\movies\\pushpa.mp4");
////			File file = new File("D:\\movies\\pushpa.mp4");
////			long fileSize = file.length();
////			byte[] allBytes = new byte[(int) fileSize];
////			
////			//fileInputStream.read(allBytes);
////			movie.setTrailer("D:\\movies\\movieStore\\"+file.getName());
////			movie.setReleaseDate("2025-07-12");
////			String result = movieService.addMovie(movie);
////			if(result.equals("success"))
////			{
////				fileOutputStream = new FileOutputStream("D:\\movies\\movieStore"+file.getName());
////				//byte[] data = new byte[(int) file.length()];
////				fileInputStream.read(allBytes);
////				fileOutputStream.write(allBytes);
////			}
////			
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		finally {
////			try {
////				fileInputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		
////		movie.setTrailer(null);
//		
//		
//		
//		
//		//second case
////		FileOutputStream fileOutputStream =null;
////		try {
////			Optional<Movie> optional = movieService.getMovieById("mov001");
////			if(optional.isEmpty())
////			{
////				System.out.println("record not found");
////				
////			}
////			else
////			{
////				//we should print the info and copy the file to movies folder with name pushpa2.
////				Movie movie = optional.get();
////				
////				fileOutputStream = new FileOutputStream("D:\\movies\\read\\pushpa2.mp4");
////				fileOutputStream.write(movie.getTrailer());
////			}
////		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | NameNotFoundException
////				| LocationNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}finally {
////			try {
////				fileOutputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
//		
//		
//		//first case
////		Movie movie = new Movie();
////		movie.setId("mov001");
////		movie.setAgeLimit(18);
////		movie.setCast("allu arjun");
////		movie.setLanguage("hindi");
////		movie.setLength(250);
////		movie.setName("pushpa");
////		movie.setGenre("action");
////		
////		FileInputStream fileInputStream = null;
////		try {
////			fileInputStream = new FileInputStream("D:\\movies\\pushpa.mp4");
////			long fileSize = new File("D:\\movies\\pushpa.mp4").length();
////			byte[] allBytes = new byte[(int) fileSize];
////			movie.setTrailer(allBytes);
////			movie.setReleaseDate("2025-07-12");
////			movieService.addMovie(movie);
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		finally {
////			try {
////				fileInputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
////		
////		movie.setTrailer(null);
//		
//		
//		
////		applicationContext.close();
//	}
////		
////	
//	
//}
