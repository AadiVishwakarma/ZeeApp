package com.zee.zee5app.dto;

import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@EqualsAndHashCode

@NoArgsConstructor
@ToString

//90% time we will use javax annotations
@Entity //entity class is used for ORM
@Table(name="register",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "email")}) // to change table name

public class User implements Comparable<User> {
	
	
//	public Register(String id,String firstname,String lastName, String email, String password, BigDecimal contactNumber) throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException	
//	{
//		super();
//		this.setId(id);
//		this.setFirstName(firstname);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//		this.contactNumber = contactNumber;
//	}
	
	@Id //it will consider this column as PK 
	@Column(name="regId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@NotBlank
	@Size(max=50)
	private String username;
	
	@Size(max=50)
	@NotBlank
	private String firstName;
	
	@Size(max=50)
	@NotBlank
	private String lastName;
	
	@Size(max=50)
	@Email
	private String email;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	
	
	
	
	
	@Override
	public int compareTo(User o)
	{
		return this.id.compareTo(o.getId());
	}

	/*
	 * 
	 * for descending order
	 * @Override
	public int compareTo(Register o)
	{
		return o.id.compareTo(this.getId());
	}
	 */
	
	@ManyToMany(fetch = FetchType.LAZY)
	
	//3rd table
	@JsonIgnore
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="regId"), 
	inverseJoinColumns = @JoinColumn(name="roleId")) //maintain register-user(regId is PK)-role(roleId is PK) relationship
	private Set<Role> roles = new HashSet<>();
	
//	@OneToOne(mappedBy = "register",cascade=CascadeType.ALL)
//	private Subscription subscription;
//	
//	@OneToOne(mappedBy = "register", cascade=CascadeType.ALL)
//	private Login login;



	public User(String username,String firstName, String lastName ,String email,String password) {
	
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName=firstName;
		this.lastName = lastName;
	}
	
}

