package com.loan.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.loan.app.model.CustomerDetails;

public interface LoanAppService {

	public CustomerDetails saveCustomer(String customerDetails, MultipartFile pancard, MultipartFile incomeCertificate,
			                            MultipartFile adharcard, MultipartFile pphoto, MultipartFile ssign, MultipartFile bankpassbook);

	public List<CustomerDetails> getCustomerData();

}
