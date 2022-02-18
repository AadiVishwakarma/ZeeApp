package com.learning.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dto.FoodType;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.FoodTypeRepository;
import com.learning.service.FoodTypeService;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {

	@Autowired
	FoodTypeRepository foodTypeRepository;
	
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public String addFoodType(FoodType foodType) {
		// TODO Auto-generated method stub
		FoodType foodType2 = foodTypeRepository.save(foodType);
		if(foodType2!=null)
			return "food type added";
		return "fail";
	}


	

//	@Override
//	public void deleteFoodType(int foodId) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<FoodType> optional;
//		optional = this.getFoodTypeById(foodId);
//		if(optional.isEmpty()) {
//			throw new IdNotFoundException("foodId not found");
//		}
//		else {
//			foodTypeRepository.deleteById(foodId);;
//			
//		}
//
//	}
//
//	@Override
//	public Optional<FoodType> getFoodTypeById(int foodTypeId) {
//		// TODO Auto-generated method stub
//		return foodTypeRepository.findById(foodTypeId);
//	}
}
