package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	@Column(name="username")
	private String userName;
	
	@NotBlank
	private String password;
	
//	@NotBlank
//	private String regId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="regId",nullable=false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private User register;
	
	
//	@Enumerated(EnumType.STRING)
//	private EROLE erole;
//	
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.userName.compareTo(this.getUserName());
	}

	
}
