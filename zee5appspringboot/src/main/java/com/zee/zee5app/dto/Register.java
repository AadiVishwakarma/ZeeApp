package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.AccessLevel;
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
//@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

//90% time we will use javax annotations
@Entity //entity class is used for ORM
@Table(name="reg") // to change table name

public class Register implements Comparable<Register> {
	
	
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
	
	private String id;
	//want to have length of 6 min
	
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
	
	
	@Size(min=10)
	@NotBlank
	private String contactNumber;
	
	
	
	@Override
	public int compareTo(Register o)
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
	
	@ManyToMany
	
	//3rd table
	@JoinTable(name="user_roles", joinColumns = @JoinColumn(name="regId"), 
	inverseJoinColumns = @JoinColumn(name="roleId")) //maintain register-user(regId is PK)-role(roleId is PK) relationship
	private Set<Role> roles = new HashSet<>();
	
	@OneToOne(mappedBy = "register")
	private Subscription subscription;
}

