package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.FoodType;

//will handle singleton instance by data jpa
@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {

}
