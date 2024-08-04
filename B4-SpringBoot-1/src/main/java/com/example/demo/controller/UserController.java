package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;

@RestController
public class UserController {
	
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){

		
		User user1= new User(101,"sachin", "washim");
		User user2= new User(102,"shourya", "hingoli");
		User user3= new User(103,"Ishu", "risod");
		
		List<User> user= new ArrayList<>();
		
		
		user.add(user1);
		
		user.add(user2);
		
		user.add(user3);
		
		
		return user;
	}
	
	@GetMapping("/getSingleUser")
	public User getUser() {
		User user= new User(104,"rohit", "pune");
		User user2= new User(105, "sandesh", "akola");
		return user;
		
	}

}
