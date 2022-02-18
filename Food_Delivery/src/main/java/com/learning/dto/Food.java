package com.learning.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //used for ORM
@Table(name= "food",uniqueConstraints = {@UniqueConstraint(columnNames="foodName")})//to change table name
public class Food implements Comparable<Food>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="foodId")
	private Long foodId;
	
	@NotBlank
	private String foodName;
	
	private float foodCost;
	
	private String description;

	
	private String Link;
	
	//compare 2 strings lexicographically
	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		return this.foodId.compareTo(o.getFoodId());
	}
	
 //For multiple food items there are multiple food types available so many to many 
	@ManyToMany
	@JoinTable(name = "food_foodtypes", joinColumns = @JoinColumn(name = "foodId"), inverseJoinColumns = @JoinColumn(name = "foodTypeId"))
	private Set<FoodType> foodTypes = new HashSet<>();
}
