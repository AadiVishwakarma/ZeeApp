package com.learning.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.FoodService;

// for creating Restful controller
@RestController
@RequestMapping("/api/food")
public class FoodController {
	@Autowired
	FoodService foodService;
	
	//add record
	 @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addFood")
	public ResponseEntity<?> addFood(@Valid @RequestBody Food food) throws AlreadyExistsException {
		
	
		Food result = foodService.addFood(food);
		return ResponseEntity.status(201).body(result);
		
		}
	
	//retrieve single record
	@GetMapping("/{foodId}")
	 @PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<?> getFoodById(@PathVariable("foodId") String foodId) throws IdNotFoundException{
		Optional<Food> result = foodService.getFoodById(foodId);
		return ResponseEntity.ok(result);	
		
	}
	
	//retrieve all records
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') || hasRole('ADMIN')")
	public ResponseEntity<?> getAllFoodDetails(){
		Optional<List<Food>> optional = foodService.getAllFoodDetails();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
	@DeleteMapping("/delete/{foodId}")
	 @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteFoodById(@PathVariable("foodId") String foodId) throws IdNotFoundException, SQLException
	{
		String result = foodService.deleteFood(foodId);
		Map<String, String> map = new HashMap<>();
		map.put("message", "food item deleted");
		return ResponseEntity.status(201).body(result);
	}
	
	@PutMapping("/update/{foodId}")
	 @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateFood(@PathVariable("foodId") String foodId, @RequestBody Food food) throws IdNotFoundException
	{
		Food result = foodService.updateFood(foodId, food);
		return ResponseEntity.status(201).body(result);
	}
}
