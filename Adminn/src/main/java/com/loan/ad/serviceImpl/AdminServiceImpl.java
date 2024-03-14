package com.loan.ad.serviceImpl;

import java.util.List;
import java.util.Optional;

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


	@Override
	public EmployeeDetails updateEmployee(EmployeeDetails ed) {
		EmployeeDetails emd = adminrepository.save(ed);
		return emd;
	}


	@Override
	public List<EmployeeDetails> getEmployeeData() {
		List<EmployeeDetails> ell = adminrepository.findAll();
		return ell;
	}
	
	@Override
    public EmployeeDetails getEmployeeByName(String employeeName) {
		EmployeeDetails getrecord=adminrepository.findByEmployeeName(employeeName);
		
		if(getrecord!=null)
		{
			return getrecord;
		}
		else
		{
			return null;
		}
}


	@Override
	public void deleteemp(int n) {
		adminrepository.deleteById(n);
		
	}


	
}
