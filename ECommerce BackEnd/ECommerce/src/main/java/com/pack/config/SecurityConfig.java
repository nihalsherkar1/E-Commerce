//package com.pack.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration 
//@EnableMethodSecurity
//public class SecurityConfig  {
//	
//	 
//	
//	 
//	
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
////		http.csrf().disable()
////        .authorizeRequests()
////            .requestMatchers("/user/register").permitAll() // Allow registration without authentication
////            .anyRequest().authenticated() // All other requests require authentication
////        .and()
////        .formLogin(); // Use form-based login
////
////    return http.build();
//		
//		http.exceptionHandling()
//		.authenticationEntryPoint((req,res,exc)->  res.sendError(HttpStatus.UNAUTHORIZED.value() , "Not yet authenticated"))
//		.and()
//		.cors()
//		.and()
//		.csrf().disable()
//		.authorizeHttpRequests()
////		.requestMatchers("/user/login").hasRole("USER")
//		 .requestMatchers("/user/**").permitAll()
//		 .requestMatchers("/products/**").permitAll()
//		 .requestMatchers("/cart/**").permitAll()
//		  
//		 .anyRequest()
//		 .authenticated()
//		 .and()
//		 .sessionManagement()
//		 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		 .and();
//		
//		return http.build();
//		
//	}
//	
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
//		return config.getAuthenticationManager();
//	}
//	 
//	
//}
