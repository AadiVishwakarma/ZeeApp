package com.learning.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.dto.User;


import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails{

	private Long id;

	private String username;

	private String email;
	
	private String address;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;
	// authorities ~ user roles

	private UserDetailsImpl(Long id, String username, String email, String address, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address= address;
		this.authorities = authorities;
	}

	// somewhere it is storitng authorities
	public static UserDetailsImpl build(User user) {// it should build the userdetailsimpl object

		// it will transform your set to stream
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName().toString())).collect(Collectors.toList());

		// map will read all the roles

		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(), user.getAddress(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
		// this is returning but should be stored somewhere
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub

		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;

		return Objects.equals(id, user.id);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
}
