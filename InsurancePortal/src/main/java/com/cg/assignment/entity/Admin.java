package com.cg.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adminModule")
@Data
@NoArgsConstructor

public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;

	private String adminName;
	private String password;
	private String emailId;
	private long phoneNumber;
//	private String gender;
//	
//	private String userRole;
//	private String address;
//	
	public Admin(int adminId, String adminName, String password, String emailId, long phoneNumber) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}
	
}


