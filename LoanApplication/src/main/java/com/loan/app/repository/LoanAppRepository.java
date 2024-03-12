package com.loan.app.repository;

import org.springframework.stereotype.Repository;

import com.loan.app.model.CustomerDetails;

@Repository
public interface LoanAppRepository {

	public void save(CustomerDetails cd);

}
