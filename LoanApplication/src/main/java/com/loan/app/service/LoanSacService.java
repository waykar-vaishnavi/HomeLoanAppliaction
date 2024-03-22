package com.loan.app.service;

import java.util.List;
import java.util.Optional;

import com.loan.app.model.CustomerDetails;
import com.loan.app.model.Sanction;

public interface LoanSacService {

	Optional<CustomerDetails> findById(int cusid);

	CustomerDetails savesactiondata(CustomerDetails customerDetails);

}
