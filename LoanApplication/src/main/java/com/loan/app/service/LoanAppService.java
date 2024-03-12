package com.loan.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.loan.app.model.CustomerDetails;

public interface LoanAppService {

	public CustomerDetails saveCustomer(String customerDetails, MultipartFile pancard, MultipartFile incomeCertificate,
			                            MultipartFile adharcard, MultipartFile pphoto, MultipartFile ssign, MultipartFile bankpassbook);

}
