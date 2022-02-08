package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.dto.Food;

public interface FoodRepository extends JpaRepository<Food, String> {

}
