package com.tsv.diz.service.auth;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tsv.diz.model.User;
import com.tsv.diz.repository.UserRepository;

@Service
public class UserRepoServiceImpl {

	private UserRepository userRepository;

	public UserRepoServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
