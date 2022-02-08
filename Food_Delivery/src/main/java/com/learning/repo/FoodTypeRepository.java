package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.FoodType;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {

}
