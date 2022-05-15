package com.devsuperior.jcprmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.jcprmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	
}
