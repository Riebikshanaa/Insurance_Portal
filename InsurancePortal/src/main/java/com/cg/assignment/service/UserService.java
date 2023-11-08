package com.cg.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.assignment.entity.User;
import com.cg.assignment.exceptions.InvalidUserException;
import com.cg.assignment.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User registerUser(User user)throws InvalidUserException {
	
		if(user.getUserName().equals("")) {
			throw new InvalidUserException("User name","User Name is null");
		}
		
		if(user.getEmailId().equals("")) {
			throw new InvalidUserException("Email Id","Email Id cannot be null");
		}
		if(user.getPassword().equals("")) {
			throw new InvalidUserException("Password","Password cannot be null");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}


	@Override
	public User getUserById(int userId) {
		
		User userFromDB = userRepository.getReferenceById(userId);
		userRepository.getReferenceById(userId);
	
		return userFromDB;
	}

	@Override
	public User updateUser(int userId) {
	
		User updatedUser = userRepository.getReferenceById(userId);
		userRepository.save(updatedUser);
		return updatedUser;
	}

	

}


