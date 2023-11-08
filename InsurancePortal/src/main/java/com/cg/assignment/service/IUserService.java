package com.cg.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.assignment.entity.User;

@Service
public interface IUserService {
	
	User registerUser(User user)throws Exception;
	List<User> getAllUsers();
	User getUserById(int userId);
	User updateUser(int userId);

}
