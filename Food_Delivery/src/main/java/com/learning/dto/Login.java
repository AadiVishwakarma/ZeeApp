package com.learning.dto;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "login")
public class Login implements Comparable<Login>{
	
	@Id
	@Column(name="email")
	private String email;
	
	@NotBlank
	private String password;
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return this.email.compareTo(o.getEmail());
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	
    @JoinColumn(name = "regId",nullable=false)
//	@JsonProperty(access = Access.WRITE_ONLY)
	private User user;
	
}
