package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}
	
	@GetMapping("/user/{username}/{password}")
	public ResponseEntity<User> getUser(@PathVariable String username, @PathVariable String password) {
		List<User> users = this.userRepository.findAll();
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
				return ResponseEntity.ok(users.get(i));
			}
		}
		return null;
	}
	
	@PostMapping("users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
