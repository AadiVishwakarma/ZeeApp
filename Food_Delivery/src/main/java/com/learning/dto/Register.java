package com.learning.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor

@Entity //used for ORM
@Table(name= "register")//to change table name
public class Register implements Comparable<Register>{
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "regId")
	private String id;
	
	@Email
	private String email;
	
	@NotBlank
	private String name;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotBlank
	private String address;
	
	
	//compares two strings lexicographically
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(this.getId());
	}
	
	//one to one mapping because for each user there exists unique 1 login details
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Login login;

}
