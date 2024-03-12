package com.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.CustomerEnquiryDetails;
import com.loan.service.EnquiryService;

@RestController
public class EnquiryController {
	
	@Autowired
	EnquiryService enquiryservice;
	
	@PostMapping("/Add_customer_Enquiry")
	public ResponseEntity<String> addCustomerenquiry(@RequestBody CustomerEnquiryDetails ced)
	{
		CustomerEnquiryDetails cceedd = enquiryservice.saveEnquiryDetails(ced);
		return new ResponseEntity<String>("Customer Enquiry Added Successfully",HttpStatus.CREATED); 
	}
	
}
