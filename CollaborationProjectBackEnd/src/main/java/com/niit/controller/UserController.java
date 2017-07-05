package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDAO;
import com.niit.model.User;

//@RestController
public class UserController {
	@Autowired UserDAO userDAO;
	@Autowired HttpSession session;
	
	@GetMapping("/getUsers")
	public List<User> getAllUsers(){
		return userDAO.list();
	}
	
	@PostMapping("/validate")
	public User validateUser(@RequestBody User user){
		user = userDAO.validate(user.getUserId(), user.getPassword());
		if(user == null) {
			user = new User();
			user.setErrorCode("404");
			user.setErrorMessage("Invalid login details!");
		} else {
			String fullName = user.getFirstname() +" "+ user.getLastname();
			
			user.setIsonline("true");
			userDAO.update(user);
			user.setErrorCode("200");
			user.setErrorMessage("Login Successfull!");
			session.setAttribute("User", user);
			session.setAttribute("loggedInUserId", user.getUserId());
			session.setAttribute("loggedInUserRole", user.getRole());
		}
		return user;
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user){
		user.setIsonline("false");
		user.setRole("ROLE_USER");
		user.setStatus("NA");
		if(userDAO.save(user)){
			user.setErrorCode("200");
			user.setErrorMessage("Registration Successfull!");
		} else {
			user.setErrorCode("404");
			user.setErrorMessage("Failed to Register! Please try again.");
		}
		return user;
	}
	
	@GetMapping("/signOut")
	public User signOut(){
		User user = (User) session.getAttribute("User");
		user.setIsonline("false");
		userDAO.update(user);
		session.invalidate();
		user = new User();
		user.setErrorCode("200");
		user.setErrorMessage("Sign Out successfull");
		return user;
		
	}
	
	@PutMapping("/approveUser/{userId}")
	public User approveUser(@PathVariable String userId){
		User user = userDAO.getUserById(userId);
		if(changeStatus(user, "A")){
			user.setErrorCode("200");
			user.setErrorMessage("User approved successfull");
		} else {
			user.setErrorCode("404");
			user.setErrorMessage("Failed to approve user! Please try again.");
		}
		return user;
	}
	
	@PutMapping("/rejectUser/{userId}")
	public User rejectUser(@PathVariable String userId){
		User user = userDAO.getUserById(userId);
		if(changeStatus(user, "R")){
			user.setErrorCode("200");
			user.setErrorMessage("User rejected successfully");
		} else {
			user.setErrorCode("404");
			user.setErrorMessage("Failed to reject user! Please try again.");
		}
		return user;
	}
	
	private boolean changeStatus(User user, String status){
		user.setStatus(status);
		return userDAO.update(user);
	}
}
