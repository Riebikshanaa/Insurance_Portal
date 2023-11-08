package com.cg.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.assignment.entity.Admin;
import com.cg.assignment.entity.User;
import com.cg.assignment.exceptions.InvalidUserException;
import com.cg.assignment.repository.AdminRepository;
import com.cg.assignment.service.IAdminService;


@Service
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin registerAdmin(Admin admin)throws InvalidUserException {
	
		if(admin.getAdminName().equals("")) {
			throw new InvalidUserException("User name","User Name is null");
		}
		
		if(admin.getEmailId().equals("")) {
			throw new InvalidUserException("Email Id","Email Id cannot be null");
		}
		if(admin.getPassword().equals("")) {
			throw new InvalidUserException("Password","Password cannot be null");
		}
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {

		return adminRepository.findAll();
	}
	
	@Override
	public Admin getadminById(int adminId) {
		
		Admin adminFromDB = adminRepository.getReferenceById(adminId);
		adminRepository.getReferenceById(adminId);
	
		return adminFromDB;
	}

	@Override
	public Admin updateAdmin(int adminId) {
	
		Admin updatedAdmin =adminRepository.getReferenceById(adminId);
		adminRepository.save(updatedAdmin);
		return updatedAdmin;
	}

}


