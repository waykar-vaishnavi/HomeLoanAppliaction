package com.loan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin("*")
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

	 
	 @PutMapping("/edit_customer/{customerApplicationId}")
	 public ResponseEntity<CustomerDetails> editCustomerData(@PathVariable("customerApplicationId") int cid, @RequestBody CustomerDetails cd)
	 {
			CustomerDetails cmpd = loanappservice.updateCustomerById(cd);
			
			return new ResponseEntity<CustomerDetails>(cmpd,HttpStatus.OK);
	 }
	 
	 @GetMapping("/getsingleCutomer/{customerApplicationId}") //get single customer by id
	 public ResponseEntity<CustomerDetails> getSingleCustomer(@PathVariable("customerApplicationId") int cid) 
	 {
		 CustomerDetails ccd = loanappservice.getByIdCustomer(cid);
		 return new ResponseEntity<CustomerDetails>(ccd, HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete_customer/{customerApplicationId}")
	 public ResponseEntity<String> deleteCustomer(@PathVariable("customerApplicationId") int csid)
	 {
		 loanappservice.deleteCustomerById(csid);
		 return new ResponseEntity<String>("Delete customer data successfully",HttpStatus.OK);
	 }

	 @GetMapping("/getcibilscore")
	   public ResponseEntity<Integer> cibilcheck()
	   {
		int checkcibilcheck=loanappservice.checkcibil();
		return new ResponseEntity<Integer>(checkcibilcheck,HttpStatus.OK);
	   }

}
