package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.EFoodType;
import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.FoodRepository;
import com.learning.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public Food addFood(Food food) {
//		if(foodRepository.existsById(food.getFoodId())) {
//			throw new AlreadyExistsException("This record already exists");
//		}
//		// TODO Auto-generated method stub
//		Food food2 = foodRepository.save(food);
//		if (food2 != null) {
//			return food2;
//		} else {
//			return null;
//		}
		Food food2 = foodRepository.save(food);
		if(food2 != null)
		{
			return food2;
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public Food updateFood(String foodId, Food food) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(!this.foodRepository.existsById(foodId))
			throw new IdNotFoundException("invalid id");
		
		return foodRepository.save(food);
	}

	@Override
	public Optional<Food> getFoodById(String foodId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return foodRepository.findByFoodId(foodId);
	}

	@Override
	public String deleteFood(String foodId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		try {
			Optional<Food> optional = this.getFoodById(foodId);
			if(optional==null) {
				throw new IdNotFoundException("food not found");
			}
			else {
				foodRepository.deleteByFoodId(foodId);
				return "food deleted";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Food>> getAllFoodDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(foodRepository.findAll());
	}
}
