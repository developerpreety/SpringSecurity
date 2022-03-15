package com.practice.springsecurity.security;

import com.practice.springsecurity.entity.ApplicationUser;
import com.practice.springsecurity.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));

		return UserDetailsImpl.build(applicationUser);

	}
}
