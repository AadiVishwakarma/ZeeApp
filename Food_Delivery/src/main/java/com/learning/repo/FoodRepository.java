package com.learning.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Food;

//will handle singleton response
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

	Optional<Food> findByFoodId(Long foodId);

	void deleteByFoodId(Long foodId);

	boolean existsById(Long foodId);

}
