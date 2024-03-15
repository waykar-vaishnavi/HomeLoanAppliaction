package com.loan.app.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loan.app.model.CustomerDetails;
import com.loan.app.service.LoanAppService;

@RestController
public class LoanAppController
{
    @Autowired
    private LoanAppService loanappservice;
    
	@PostMapping("/Add_Customer_Details")
	   public ResponseEntity<String> addCustomerData(@RequestPart ("customer") String customerDetails,
			                                         @RequestPart ("pan") MultipartFile pancard,
			                                         @RequestPart ("income") MultipartFile incomeCertificate,
			                                         @RequestPart ("adhar") MultipartFile adharcard,
			                                         @RequestPart ("Profilephoto") MultipartFile pphoto,
			                                         @RequestPart ("sign") MultipartFile ssign,
			                                         @RequestPart ("passbook") MultipartFile bankpassbook)
	   {
		   CustomerDetails ccd = loanappservice.saveCustomer(customerDetails,pancard,incomeCertificate,adharcard,pphoto,ssign,bankpassbook);
		   return new ResponseEntity<String>("Customer Details Added Successfully",HttpStatus.CREATED);
	   }
	
	 @GetMapping("/get_Customer")
	   public ResponseEntity<List<CustomerDetails>> getCusomer()
	   {
		   List<CustomerDetails> emp = loanappservice.getCustomerData();
		   return new ResponseEntity<List<CustomerDetails>>(emp,HttpStatus.OK);
	   }
	 
	 
	 
}
