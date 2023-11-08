package com.cg.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.assignment.entity.Admin;

@Service
public interface IAdminService {
	
	Admin registerAdmin(Admin admin)throws Exception;
	List<Admin> getAllAdmins();
	Admin updateAdmin(int adminId);
	Admin getadminById(int adminId);

}
