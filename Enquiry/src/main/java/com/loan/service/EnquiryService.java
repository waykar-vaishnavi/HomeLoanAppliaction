package com.loan.service;

import java.util.List;

import com.loan.model.CustomerEnquiryDetails;

public interface EnquiryService {

	public CustomerEnquiryDetails saveEnquiryDetails(CustomerEnquiryDetails ced);

	public List<CustomerEnquiryDetails> getEnquiryDetailsss();

	public CustomerEnquiryDetails getEnquiryById(int customerEnquiryId);

	public void saveCibil(CustomerEnquiryDetails customerEnquiryDetails);

}
