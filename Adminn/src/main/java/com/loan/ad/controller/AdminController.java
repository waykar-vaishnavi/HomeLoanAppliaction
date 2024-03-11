package com.loan.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loan.ad.model.EmployeeDetails;
import com.loan.ad.service.AdminService;

@RestController
public class AdminController 
{
	 @Autowired private AdminService adminservice;
	   
	   @PostMapping("/Add_Employees")
	   public ResponseEntity<String> addEmployees(@RequestPart ("employees") String employeeDetails,
			                                      @RequestPart ("profile") MultipartFile profileImg)
	   {
		   EmployeeDetails emp = adminservice.saveEmployee( employeeDetails,profileImg);
		   return new ResponseEntity<String>("Employee Data Added Successfully",HttpStatus.CREATED); 
	   }
}
