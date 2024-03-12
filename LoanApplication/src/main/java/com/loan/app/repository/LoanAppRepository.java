package com.loan.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.loan.app.model.CustomerDetails;

@Repository
public interface LoanAppRepository {

	public void save(CustomerDetails cd);

	public List<CustomerDetails> findAll();

}
