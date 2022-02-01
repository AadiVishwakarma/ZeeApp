package com.zee.zee5app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Login implements Comparable<Login> {
	
	public Login(String userName, String password, String regId, ROLE role)
	{
		super();
		this.userName = userName;
		this.password = password;
		this.setRegId(regId);
		this.role = role;
	}
	
	
//	public Login() {
//		// TODO Auto-generated constructor stub
//	}


	private String userName;
	private String password;
	private String regId;
	private ROLE role;
	
	
	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return o.userName.compareTo(this.getUserName());
	}
}
