package com.tsv.diz.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tsv.diz.model.User;
import com.tsv.diz.service.auth.UserRepoServiceImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepoServiceImpl userRepoServiceImpl;

	public UserDetailsServiceImpl(UserRepoServiceImpl userRepoServiceImpl) {
		this.userRepoServiceImpl = userRepoServiceImpl;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepoServiceImpl.findByEmail(email);
		if (!user.isPresent()) {
			throw new UsernameNotFoundException(email);
		}

		return user.get();
	}

}
