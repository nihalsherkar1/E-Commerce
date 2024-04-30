package com.pack.services;

import java.util.List;

import com.pack.entities.User;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

	
	public User saveUser(User user,String role);
	
	public List<User> getAllUsers( );
	
	public User getUserById(Long id);
	
	public User updateUser(Long id, User user);
	
	public String deleteUser(Long id);
	
//	public Boolean signIn(String email,String password);
	
	public User signIn(String email,String password);
	
	public void signOut(HttpServletRequest request);
}
