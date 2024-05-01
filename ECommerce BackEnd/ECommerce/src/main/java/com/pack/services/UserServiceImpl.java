package com.pack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;

import com.pack.entities.User;
import com.pack.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService  {
	
	
	@Autowired
	private UserRepository userRepository;
	
	 

	@Override
	public User saveUser(User user,String role) {
		  user.setRole(role);
		
		 User data=userRepository.save(user);
		return data;
	}

	@Override
	public List<User> getAllUsers( ) {
		 List<User>data=userRepository.findAll();
		return data;
	}

	@Override
	public User getUserById(Long id) {
		 User data=userRepository.findById(id).orElse(null);
		return data;
	}

	@Override
	public User updateUser(Long id, User user) {
		
		User data=userRepository.findById(id).orElse(null);
		
		if(data != null) {
			data.setUsername(user.getUsername());
			data.setEmail(user.getEmail());
			data.setPassword(user.getPassword());
			return userRepository.save(data);
		}
		else {
			return null;
		}
		
		
		
	}

	@Override
	public String deleteUser(Long id) {
		
		User data=userRepository.findById(id).get();
		
		if(data != null) {
			userRepository.deleteById(id);
			return "User Deleted Successfully....";
		}
		
		return "Something went wrong...Please Check!!!!";
	}

	
	
	@Override
	public User signIn(String email, String password) {
		
		/* Here user find user using email*/
		User user=userRepository.findByEmail(email);
		
		/* Here check User getting null and user password  matching with password saved in DB   */
		if(user != null && user.getPassword().equals(password)) {
			
			/* user and password match it will return the user */
			return user;
		}
		
		return null;
	}

//	@Override
//	public Boolean signIn(String email, String password) {
//		 
//		User user=userRepository.findByEmail(email);
//		
//		if(user !=null && user.getPassword().equals(password)) {
//			return true;
//		}
//		
//		return false;
//	}
	
	 
	 @Override
	    public void signOut(HttpServletRequest request) {
	        request.getSession().invalidate();
	    }
	
	

}
