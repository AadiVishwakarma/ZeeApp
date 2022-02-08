package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Food;

//will handle singleton response
@Repository
public interface FoodRepository extends JpaRepository<Food, String> {

}
