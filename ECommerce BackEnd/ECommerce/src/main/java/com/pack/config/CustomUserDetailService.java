//package com.pack.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.pack.entities.User;
//import com.pack.repository.UserRepository;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//	@Autowired
//    private UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		 
//		User user=userRepository.findByEmail(email);
//		if(user == null) {
//			throw new UsernameNotFoundException("User not found with email");
//			
//		}
//		
//		return new CustomUserDetails(user);
//		 
//	}
//
//}
