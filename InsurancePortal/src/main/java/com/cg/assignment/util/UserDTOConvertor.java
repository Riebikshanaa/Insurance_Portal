package com.cg.assignment.util;

import org.springframework.stereotype.Component;

import com.cg.assignment.dto.UserDTO;
import com.cg.assignment.entity.User;

@Component
public class UserDTOConvertor {
	
	public UserDTO convertTo(User user) {

		return new UserDTO(user.getUserId(), user.getUserName(),user.getPassword(),user.getEmailId(),user.getPhoneNumber());

}
}
