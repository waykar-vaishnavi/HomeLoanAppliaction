package com.loan.app.service;


import java.util.Optional;

import com.loan.app.model.CustomerDetails;


public interface LoanSacService {

	Optional<CustomerDetails> findById(int cusid);

	CustomerDetails savesactiondata(CustomerDetails customerDetails);

}
