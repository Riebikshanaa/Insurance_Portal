package com.cg.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.assignment.dto.UserDTO;
import com.cg.assignment.entity.User;
import com.cg.assignment.service.IUserService;
import com.cg.assignment.util.UserDTOConvertor;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins= {"http://localhost:4200","http://localhost:6001"},allowedHeaders="*")


public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IUserService userService;

	@Autowired
	UserDTOConvertor dtoConvertor;

	public UserController() {
		logger.info("User user Called");
		System.err.println("User user Called");

	}
	@PostMapping("/add")

	public ResponseEntity<UserDTO> saveCustomer(@RequestBody User user) throws Exception {

		User savedCustomer = userService.registerUser(user);
		logger.info("----> Customer Saved <----" + savedCustomer);

		UserDTO dto = dtoConvertor.convertTo(savedCustomer);

		return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<UserDTO>> getAllUsers() {

		List<User> allUsersInDB = userService.getAllUsers();

		List<UserDTO> dtoList = new ArrayList<>();
		for (User user : allUsersInDB) {

			UserDTO dto = dtoConvertor.convertTo(user);
			dtoList.add(dto);
		}

		return new ResponseEntity<List<UserDTO>>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping("/login/{uId}/{password}")
	public ResponseEntity<UserDTO> doLogin( @PathVariable int uId,@PathVariable String password)
	{
		User userFromDB = userService.getUserById(uId);
		System.err.println(userFromDB);
		if (userFromDB != null) {
			if(userFromDB.getPassword().equals(password)) {
				System.err.println("inside if");
				UserDTO dto = dtoConvertor.convertTo(userFromDB);
				return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
			}
			return null;
		} else
			return null;
	}
	

	@GetMapping("/userbyid/{userId}")

	public ResponseEntity<UserDTO> getUserById(@PathVariable int userId) throws Exception {
		User userFromDB = userService.getUserById(userId);
		if (userFromDB != null) {
			UserDTO dto = dtoConvertor.convertTo(userFromDB);
			return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
		} else
			return null;
	}

	@PutMapping("/updateuser/{userId}")

	public String updatedUser(@PathVariable int userId) {

		User updatedUser = userService.getUserById(userId);
		return updatedUser.toString();
	}

}




