package com.loan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.model.CustomerEnquiryDetails;
import com.loan.repository.EnquiryRepository;
import com.loan.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	@Autowired
	EnquiryRepository enquiryrepo;

	@Override
	public CustomerEnquiryDetails saveEnquiryDetails(CustomerEnquiryDetails ced) {
		CustomerEnquiryDetails ce = enquiryrepo.save(ced);
		return ce;
	}

}
