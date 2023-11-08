package com.cg.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class AdminDTO {
	
	private int adminId;
	private String userName;
	private String password;
	private String emailId;
	private long phoneNumber;

}
