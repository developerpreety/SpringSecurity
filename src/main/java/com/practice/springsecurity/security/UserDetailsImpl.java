package com.practice.springsecurity.security;

import com.practice.springsecurity.entity.ApplicationUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

	private final Long id;

	private final String password;

	private final String username;

	private final String role;


	public UserDetailsImpl(Long id, String username, String password,String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role= role;
	}

	public static UserDetailsImpl build(ApplicationUser applicationUser) {

		String role="NORMAL";

		return new UserDetailsImpl(applicationUser.getId(), applicationUser.getUsername(), applicationUser.getPassword(),role);

	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
