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

import com.cg.assignment.dto.AdminDTO;
import com.cg.assignment.entity.Admin;
import com.cg.assignment.service.IAdminService;
import com.cg.assignment.util.AdminDTOConvertor;

@RestController
@RequestMapping("/admin")
//@CrossOrigin(origins= {"http://localhost:2002","http://localhost:6001"},allowedHeaders="*")



public class AdminController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

@Autowired
IAdminService adminService;

@Autowired
AdminDTOConvertor dtoConvertor;

public AdminController() {
	logger.info("admin admin Called");
	System.err.println("admin admin Called");

}
@PostMapping("/add")

public ResponseEntity<AdminDTO> saveCustomer(@RequestBody Admin admin) throws Exception {

	Admin savedAdmin = adminService.registerAdmin(admin);
	logger.info("----> Customer Saved <----" + savedAdmin);

	AdminDTO dto = dtoConvertor.convertTo(savedAdmin);

	return new ResponseEntity<AdminDTO>(dto, HttpStatus.OK);
}

@GetMapping("/list")
public ResponseEntity<List<AdminDTO>> getAllUsers() {

	List<Admin> allAdminsInDB = adminService.getAllAdmins();

	List<AdminDTO> dtoList = new ArrayList<>();
	for (Admin user : allAdminsInDB) {

		AdminDTO dto = dtoConvertor.convertTo(user);
		dtoList.add(dto);
	}

	return new ResponseEntity<List<AdminDTO>>(dtoList, HttpStatus.OK);
}


@GetMapping("/userbyid/{userId}")

public ResponseEntity<AdminDTO> getadminById(@PathVariable int adminId) throws Exception {
	Admin adminFromDB = adminService.getadminById(adminId);
	if (adminFromDB != null) {
		AdminDTO dto = dtoConvertor.convertTo(adminFromDB);
		return new ResponseEntity<AdminDTO>(dto, HttpStatus.OK);
	} else
		return null;
}

@PutMapping("/updateuser/{userId}")

public String updatedAdmin(@PathVariable int adminId) {

	Admin updatedAdmin = adminService.getadminById(adminId);
	return updatedAdmin.toString();
}

}
	
	


