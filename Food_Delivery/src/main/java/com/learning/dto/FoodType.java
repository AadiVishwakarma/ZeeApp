package com.learning.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodType {

@Id //Id must be auto generated
	
	//this act like a auto increment
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodTypeId;
	
	//it should be the value from available Enums
	
	@Enumerated(EnumType.STRING)
	private EFoodType foodType;
}
