package com.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/getEnquiry")
	public ResponseEntity< List<CustomerEnquiryDetails>>  getAllEnquiryDetails()
	{
		
		List<CustomerEnquiryDetails> ced=enquiryservice.getEnquiryDetailsss();
				return new ResponseEntity<List<CustomerEnquiryDetails>>(ced,HttpStatus.ACCEPTED) ;
	}
	
	@GetMapping("/getEnquiryById/{customerEnquiryId}")
	public ResponseEntity<CustomerEnquiryDetails> getEnquiryById(@PathVariable int customerEnquiryId){
		CustomerEnquiryDetails response = enquiryservice.getEnquiryById(customerEnquiryId);
		return new ResponseEntity<CustomerEnquiryDetails>(response,HttpStatus.FOUND);
	}
	     
	
	
	
}
