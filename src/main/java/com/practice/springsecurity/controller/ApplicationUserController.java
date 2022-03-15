package com.practice.springsecurity.controller;

import com.practice.springsecurity.entity.ApplicationUser;
import com.practice.springsecurity.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
public class ApplicationUserController {

	private final ApplicationUserService applicationUserService;

	private final PasswordEncoder passwordEncoder;


	@PostMapping("/register-user")
	public ApplicationUser saveUser(@RequestBody ApplicationUser applicationUser) {
		applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
		return applicationUserService.saveUser(applicationUser);
	}

	@GetMapping("/users")
	public List<ApplicationUser> getUser() {
		return applicationUserService.getUser();
	}

	@GetMapping("/users/{id}")
	public ApplicationUser getUserById(@PathVariable long id) {
		return applicationUserService.getUserById(id);
	}
}
