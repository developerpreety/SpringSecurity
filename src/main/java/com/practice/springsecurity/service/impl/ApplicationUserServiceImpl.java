package com.practice.springsecurity.service.impl;

import com.practice.springsecurity.entity.ApplicationUser;
import com.practice.springsecurity.repository.ApplicationUserRepository;
import com.practice.springsecurity.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {

	private final ApplicationUserRepository applicationUserRepository;

	public ApplicationUser saveUser(ApplicationUser applicationUser) {

		applicationUserRepository.save(applicationUser);
		return applicationUser;
	}

	public List<ApplicationUser> getUser() {


		List<ApplicationUser> applicationUser = applicationUserRepository.findAll();

		return applicationUser;
	}

	public ApplicationUser getUserById(long id) {

		ApplicationUser applicationUser = applicationUserRepository.findById(id).orElseThrow(null);
		return applicationUser;
	}
}
