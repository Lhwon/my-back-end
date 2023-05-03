package com.myframework.mybackend.dev.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	public UserEntity createUser(String userName, String email, String password) {
		UserEntity user = new UserEntity();
		user.setUserName(user.getUserName());
		user.setEmail(user.getEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userRepository.save(user);
		return user;
		
	}
}
