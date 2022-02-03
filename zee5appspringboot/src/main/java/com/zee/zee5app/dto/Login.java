package com.zee.zee5app.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity

@Table(name="login")
public class Login implements Comparable<Login> {
	
//	public Login(String userName, String password, String regId, ROLE role)
//	{
//		super();
//		this.userName = userName;
//		this.password = password;
//		this.setRegId(regId);
//		this.role = role;
//	}
//	


	@Id
	private String userName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String regId;
	
	@Enumerated(EnumType.STRING)
	private ROLE role;
	
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.userName.compareTo(this.getUserName());
	}
}
