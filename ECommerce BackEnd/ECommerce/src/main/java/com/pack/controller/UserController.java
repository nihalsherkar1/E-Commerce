package com.pack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.SignInDTO;
import com.pack.entities.User;
import com.pack.repository.UserRepository;
import com.pack.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	

 
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@RequestBody User user,@RequestParam("role") String role) {

		User data = userService.saveUser(user,role);

		return new ResponseEntity<User>(data, HttpStatus.CREATED);

	}
	
//	@PostMapping("/register/user")
//	public ResponseEntity<User> saveUser(@RequestBody User user) {
//		
//	    return saveUser(user, "USER");
//	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> saveUser() {

		List<User> data = userService.getAllUsers();

		return new ResponseEntity<>(data, HttpStatus.CREATED);

	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id) {

		User data = userService.getUserById(id);

		return new ResponseEntity<>(data, HttpStatus.CREATED);

	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable(name = "id") Long id ,@RequestBody  User user) {

		User data = userService.updateUser(id, user);
		System.out.println(data);

		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		 

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id) {

		String data = userService.deleteUser(id);
		
	    
		
		return new ResponseEntity<>(data, HttpStatus.OK);

	}
	
	
	 
//	@GetMapping("/signIn")
//	public ResponseEntity<String>signIn(@RequestParam("email") String email, @RequestParam("password") String password ){
//		
// 
////		Retrive email and password from dto
//		
////		String email=signInDTO.getEmail();
////		String password=signInDTO.getPassword();
//		 
//		//call userRepos
//		Boolean isAuthenticated= userService.signIn(email, password);
//		
//		if(isAuthenticated) {
//			return new ResponseEntity<>("User signed in successfully..", HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
//		}
//		
//		 
//	}
	

	@GetMapping("/login")
	public ResponseEntity<User>signIn(@RequestParam("email") String email, @RequestParam("password") String password){
		User user=userService.signIn(email, password);
		
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
 
	
	@GetMapping("/logout")
	public ResponseEntity<Void> signOut(@RequestHeader("userId") Long userId, HttpServletRequest request) {
	    // Assuming you have a UserDetailsService or similar to get the user object
	    User user = userService.getUserById(userId);
	    if (user!= null) {
	        // Invalidate the session
	        request.getSession().invalidate();
	        // You can also remove the user's session from the session registry if you're using one
	        // sessionRegistry.removeSession(user.getUsername());
	    }
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
