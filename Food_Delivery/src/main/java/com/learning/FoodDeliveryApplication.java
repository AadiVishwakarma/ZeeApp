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
		
		FoodTypeService foodTypeService = applicationContext.getBean(FoodTypeService.class);
      FoodTypeRepository foodTypeRepository = applicationContext.getBean(FoodTypeRepository.class);
		
		FoodType foodType = new FoodType();
		foodType.setFoodType(EFoodType.Mexican);
		FoodType foodType2 = new FoodType();
		foodType2.setFoodType(EFoodType.Chinese);
		FoodType foodType3 = new FoodType();
		foodType3.setFoodType(EFoodType.Indian);
		foodTypeService.addFoodType(foodType2);
		foodTypeService.addFoodType(foodType);
		foodTypeService.addFoodType(foodType3);
		Set<FoodType> foodtype = new HashSet<>();
		applicationContext.close();
	}

}
