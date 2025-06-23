package com.operation.user.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operation.user.model.User;
import com.operation.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User createUser(User user) {
		
		user.setPassword(generateRandomPassword());
		
		return repository.save(user);
	}

	public static String generateRandomPassword() {
		Random random = new Random();
		int min = 10000000; // Smallest 8-digit number
		int max = 99999999; // Largest 8-digit number
		int password = random.nextInt(max - min + 1) + min;
		return  String.valueOf(password);
	}

	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(new User());
	}

	public User modifyUser(User user) {
		// TODO Auto-generated method stub
		return repository.saveAndFlush(user);
	}

	public String dropUserById(long id) {
		// TODO Auto-generated method stub
		User var = repository.findById(id).orElse(new User());
		repository.delete(var);
		return "Entity Drop Sucessfull";
	}
	
}
