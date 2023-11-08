package com.cg.assignment.util;
import org.springframework.stereotype.Component;

import com.cg.assignment.dto.AdminDTO;
import com.cg.assignment.entity.Admin;

@Component
public class AdminDTOConvertor {
	public AdminDTO convertTo(Admin admin) {

		return new AdminDTO(admin.getAdminId(), admin.getAdminName(),admin.getPassword(),admin.getEmailId(),admin.getPhoneNumber());
	}

}
