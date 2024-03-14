package com.loan.serviceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<CustomerEnquiryDetails> getEnquiryDetailsss() {
		List<CustomerEnquiryDetails> li =enquiryrepo.findAll();
			return li;
	}

	@Override
	public CustomerEnquiryDetails getEnquiryByName(String customerFirstName) {
		CustomerEnquiryDetails response=enquiryrepo.findByCustomerFirstName(customerFirstName);
		
		if(response!=null) {
			return response;
		}
		else {
			return null;
		}
	}

}
