package com.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.CustomerEnquiryDetails;
import com.loan.service.EnquiryService;

@RestController
@CrossOrigin("*")
public class EnquiryController {
	
	@Autowired
	EnquiryService enquiryservice;
	
	@PostMapping("/Add_customer_Enquiry")
	public ResponseEntity<String> addCustomerenquiry(@RequestBody CustomerEnquiryDetails ced)
	{
		CustomerEnquiryDetails cceedd = enquiryservice.saveEnquiryDetails(ced);
		return new ResponseEntity<String>("Customer Enquiry Added Successfully",HttpStatus.CREATED); 
	}
	
	@GetMapping("/getEnquiry")
	public ResponseEntity< List<CustomerEnquiryDetails>>  getAllEnquiryDetails()
	{
		
		List<CustomerEnquiryDetails> ced=enquiryservice.getEnquiryDetailsss();
				return new ResponseEntity<List<CustomerEnquiryDetails>>(ced,HttpStatus.ACCEPTED) ;
	}
	
	@GetMapping("/getEnquiryByName/{customerFirstName}")
	public ResponseEntity<CustomerEnquiryDetails> getEnquiryByName(@PathVariable String customerFirstName){
		CustomerEnquiryDetails response = enquiryservice.getEnquiryByName(customerFirstName);
		return new ResponseEntity<CustomerEnquiryDetails>(response,HttpStatus.FOUND);
	}
}
