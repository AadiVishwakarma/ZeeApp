package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.dto.EFoodType;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;


public interface FoodService {
//	public Food addFood(Food food);
//	public Optional<Food> getFoodById(String id);
//	public Food[] getAllFood();
//	public Optional<Food> getFoodByType(EFoodType efoodType);
//	
	public Food addFood(Food food) throws AlreadyExistsException;
	public Food updateFood(String foodId, Food food) throws IdNotFoundException;
	public Food getFoodById(String foodId) throws IdNotFoundException;
	public String deleteFood(String foodId) throws IdNotFoundException;
	public Optional<List<Food>> getAllFoodDetails();
}