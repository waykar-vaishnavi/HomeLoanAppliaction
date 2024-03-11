package com.loan.ad.service;

import org.springframework.web.multipart.MultipartFile;

import com.loan.ad.model.EmployeeDetails;

public interface AdminService {

	public EmployeeDetails saveEmployee(String employeeDetails, MultipartFile profileImg);

	public EmployeeDetails getAdminSingleData(int employeeId);

}
