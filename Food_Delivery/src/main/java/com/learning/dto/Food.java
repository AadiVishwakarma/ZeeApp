package com.learning.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor

@Entity //used for ORM
@Table(name= "food")//to change table name
public class Food implements Comparable<Food>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String foodId;
	
	@NotBlank
	private String foodName;
	
	private Number foodCost;
	
	private String description;

	
	private String Link;
	
	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		return this.foodId.compareTo(o.getFoodId());
	}
	
	@ManyToMany
	@JoinTable(name = "food_foodtypes", joinColumns = @JoinColumn(name = "foodId"), inverseJoinColumns = @JoinColumn(name = "foodTypeId"))
	private Set<FoodType> foodTypes = new HashSet<>();
}
