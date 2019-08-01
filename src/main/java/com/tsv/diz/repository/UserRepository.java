package com.tsv.diz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tsv.diz.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Transactional
	Optional<User> findByEmail(String email);
	
}
