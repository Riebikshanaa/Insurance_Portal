package com.cg.assignment.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userModule")
@Data
@NoArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String userName;
	private String password;
	private String emailId;
	private long phoneNumber;
//	private String gender;
//	
//	private String userRole;
//	private String address;
//	
	
//	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	    private List<Transaction> transactions;
public User(int userId, String userName, String password, String emailId, long phoneNumber)
		 {
	super();
	this.userId = userId;
	this.userName = userName;
	this.password = password;
	this.emailId = emailId;
	this.phoneNumber = phoneNumber;
}
		
}

