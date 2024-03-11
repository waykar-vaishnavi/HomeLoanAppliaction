package com.loan.ad.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.ad.model.EmployeeDetails;
import com.loan.ad.repository.AdminRepository;
import com.loan.ad.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired private AdminRepository adminrepository;

	
	@Override
	public EmployeeDetails saveEmployee(String employeeDetails, MultipartFile profileImg)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			EmployeeDetails emmpp = mapper.readValue(employeeDetails,EmployeeDetails.class);
			emmpp.setEmployeeProfileImage(profileImg.getBytes());
			adminrepository.save(emmpp);
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
	
	return null;
	}
}
