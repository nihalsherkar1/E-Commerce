//package com.pack.config;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.pack.entities.User;
//
//public class CustomUserDetails implements UserDetails {
//	
//	@Autowired
//	private User user;
//	
//	
//
//	public CustomUserDetails(User user) {
//		super();
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		 
//		return List.of(new SimpleGrantedAuthority(user.getRole()));
//	}
//
//	@Override
//	public String getPassword() {
//		 
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		 
//		return user.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//	 
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		 
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		 
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		 
//		return true;
//	}
//
//}
