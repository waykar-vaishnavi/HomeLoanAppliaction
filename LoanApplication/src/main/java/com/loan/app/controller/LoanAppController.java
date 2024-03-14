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
	 
	 @DeleteMapping("/delete_customer/{customerApplicationId}")
	 public ResponseEntity<String> deleteCustomer(@PathVariable("customerApplicationId") int csid)
	 {
		 loanappservice.deleteCustomerById(csid);
		 return new ResponseEntity<String>("Delete customer data successfully",HttpStatus.OK);
	 }
//	 @PutMapping(value = "/updateCustomer/{customerId}")	//update customer by loan status--
//		public ResponseEntity<BaseResponse<CustomerDetails>> updateCustomer(@RequestBody String loanstatus,
//				                                                            @PathVariable("customerId") Integer customerId) throws IOException
//		{
//		    
//			Optional<CustomerDetails> customerdetails = cs.findById(customerId);
//			
//			if (customerdetails.isPresent())
//			{
//				CustomerDetails singlecustomer = customerdetails.get();	
//				if(loanstatus.equals("documentverfied")) 
//				{
//					singlecustomer.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.DocumentVerified));
//					CustomerDetails cd = cs.updateCustomer(singlecustomer);
//					BaseResponse br = new BaseResponse<>(200, "Data Successfully Updated Approved Customer", cd);
//					return new ResponseEntity<BaseResponse<CustomerDetails>>(br, HttpStatus.OK);
//				}
//				else if(loanstatus.equals("documentrejected"))
//				{
//					singlecustomer.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.DocumentRejected));
//					CustomerDetails cd2 = cs.updateCustomer(singlecustomer);
//					BaseResponse br = new BaseResponse<>(200, "Data Successfully Updated for Rejected Customer", cd2);
//					return new ResponseEntity<BaseResponse<CustomerDetails>>(br, HttpStatus.OK);	
//				}
//			}
//			else 
//			{
//				throw new CustomerNotFound();
//			}
//			BaseResponse br = new BaseResponse<>(404, "Failed to Update Data..", null);
//			return new ResponseEntity<BaseResponse<CustomerDetails>>(br,HttpStatus.NOT_FOUND);
//		
//		}
//	 @DeleteMapping("/deleteCustomer/{csid}")	//delete customer by id
//		public ResponseEntity<BaseResponse<CustomerDetails>> deleteCustomer(@PathVariable Integer csid) {
//
//			Optional<CustomerDetails> customerdetail = cs.findById(csid);
//			if (customerdetail.isPresent()) {
//				cs.deleteData(csid);
//				BaseResponse br = new BaseResponse<>(200, "Data Deleted Successfully", customerdetail);
//				return new ResponseEntity<BaseResponse<CustomerDetails>>(br, HttpStatus.OK);
//
//			} else {
//
//				throw new CustomerNotFound();
//			}
//		}
//	 @PostMapping(value = "/postCustomer", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	//post all data with multipart file
//		public ResponseEntity<BaseResponse<CustomerDetails>> postCustomer(@RequestPart("allData") String allData,
//				@RequestPart("panCard") MultipartFile file1, @RequestPart("incomeProof") MultipartFile file2,
//				@RequestPart("aadharCard") MultipartFile file3, @RequestPart("photo") MultipartFile file4,
//				@RequestPart("signature") MultipartFile file5, @RequestPart("bankPassBook") MultipartFile file6) {
//
//			
//			BaseResponse bs = null;
//			ObjectMapper om = new ObjectMapper();
//			try {
//				CustomerDetails cd1 = om.readValue(allData, CustomerDetails.class);
//				
//				cd1.getCustomerAllDocuments().setPanCard(file1.getBytes());
//				cd1.getCustomerAllDocuments().setIncomeProof(file2.getBytes());
//				cd1.getCustomerAllDocuments().setAadharCard(file3.getBytes());
//				cd1.getCustomerAllDocuments().setPhoto(file4.getBytes());
//				cd1.getCustomerAllDocuments().setSignature(file5.getBytes());
//				cd1.getCustomerAllDocuments().setBankPassBook(file6.getBytes());
//				cd1.setCustomerLoanStatus(String.valueOf(CustomerLoanStatus.pending));
//				CustomerDetails saveCustomer = cs.saveCustomer(cd1);
//				bs = new BaseResponse<>(201, "Data Saved", saveCustomer);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return new ResponseEntity<BaseResponse<CustomerDetails>>(bs, HttpStatus.OK);
//		}
}
