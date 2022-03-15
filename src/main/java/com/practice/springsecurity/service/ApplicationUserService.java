package com.practice.springsecurity.service;

import com.practice.springsecurity.entity.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {

	ApplicationUser saveUser(ApplicationUser applicationUser);

	List<ApplicationUser> getUser();

	ApplicationUser getUserById(long id);
}
