package com.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findUserByEmailAndPassword(String email, String password);
	
	public User findByEmail(String email);
	
   

}
