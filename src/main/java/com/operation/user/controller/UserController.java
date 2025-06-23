package com.operation.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.operation.user.model.User;
import com.operation.user.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User sevedUser = service.createUser(user); 
		return new ResponseEntity<>(sevedUser, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return service.findAllUser() ;
	}	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable ("id") long id) {
		return service.getUserById(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		
		User modifyUser = service.modifyUser(user); 
		return new ResponseEntity<>(modifyUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> dropUserById(@PathVariable ("id") long id) {
		return new ResponseEntity<>( service.dropUserById(id), HttpStatus.NO_CONTENT);
	}
	
}
