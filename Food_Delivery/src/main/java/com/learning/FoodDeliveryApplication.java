package com.learning;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.learning.dto.EFoodType;
import com.learning.dto.FoodType;
import com.learning.repo.FoodTypeRepository;
import com.learning.service.FoodTypeService;


@SpringBootApplication
public class FoodDeliveryApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(FoodDeliveryApplication.class, args);
	
		
//		applicationContext.close();
	}

}
