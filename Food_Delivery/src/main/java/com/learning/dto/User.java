package com.learning.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity //used for ORM
@Table(name= "register",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "email")})//to change table name

public class User implements Comparable<User>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "regId")
	private Long id;
	
	@Email
	private String email;
	
	@NotBlank
	private String username;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotBlank
	private String address;
	
	
	
	public User(String username,String email,String password,String address) {
		
		this.username = username;
		this.email = email;
		this.password = password;
		this.address=address;
	}
	
	
	//compares two strings lexicographically
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	//one to one mapping because for each user there exists unique 1 login details
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Login login;


	
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="regId"), 
	inverseJoinColumns = @JoinColumn(name="roleId")) //maintain register-user(regId is PK)-role(roleId is PK) relationship
	private Set<Role> roles = new HashSet<>();
	

}
