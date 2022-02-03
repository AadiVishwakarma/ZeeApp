package com.zee.zee5app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.EROLE;
import com.zee.zee5app.dto.Episode;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Main2 {

	public static void main(String[] args) throws AlreadyExistsException {
		// TODO Auto-generated method stub

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Zee5appspringbootApplication.class, args);
//		UserService userService = applicationContext.getBean(UserService.class);
//		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		
		//System.out.println(userRepository.existsByEmailAndContactNumber("Adi3@gmail.com","98765432103"));
		//System.out.println(userService.addUser("aditya1"));
		
		
//		MovieRepository movieRepository = applicationContext.getBean(MovieRepository.class);
//		System.out.println(movieRepository.findByNameAndLanguage("MovieName4","language4"));
//		System.out.println(movieRepository.findByName("MovieName4"));
//		System.out.println(movieRepository.findByNameAndReleaseDate("MovieName4","2026-05-04"));
//		System.out.println(movieRepository.findByCast("cast4"));
		
//		SeriesRepository seriesRepository = applicationContext.getBean(SeriesRepository.class);
//		System.out.println(seriesRepository.findByNameAndLanguage("SeriesName : 4","Language4"));
		
		
		
//		Role role = new Role();
//		role.setRoleName(EROLE.ROLE_ADMIN);
//		
//		Role role2 = new Role();
//		role2.setRoleName(EROLE.ROLE_USER);
		
//		RoleService roleService = applicationContext.getBean(RoleService.class);
//		System.out.println(roleService.addRole(role));
//		System.out.println(roleService.addRole(role2));
//		RoleRepository roleRepository = applicationContext.getBean(RoleRepository.class);
//		
//		Register register;
//		System.out.println("Add User");
//		register = new Register("adi0014", "Aditya", "Vishwakarma", "Adi14@gmail.com", "Adi00@", "9876543210",null);
//		Set<Role> roles = new HashSet<>();
//		roles.add(roleRepository.findById(1).get());
//		roles.add(roleRepository.findById(2).get());
//		register.setRoles(roles);
//		System.out.println(userService.addUser(register));
		
		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
		EpisodeService episodeService = applicationContext.getBean(EpisodeService.class);
			Series series1 = new Series("ser001", "SeriesName1","genre1", "2029-7-0", "google series ", "cast : ", 18,4, "Language1", null);
			Series series2 = new Series("ser002", "SeriesName2","genre2", "2029-7-0", "google series ", "cast : ", 18,4, "Language2", null);
//			System.out.println(seriesService.addSeries(series1)) ;
//			System.out.println(seriesService.addSeries(series2) );
			Episode episode = new Episode("ep-01", "episode1", 120, "drive", "youtube", series1);
			episodeService.addEpisode(episode);
		
		applicationContext.close();
	}
		
	
	
}
