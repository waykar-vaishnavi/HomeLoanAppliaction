package com.loan.app.serviceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loan.app.model.CustomerDetails;
import com.loan.app.repository.ScantionRepository;
import com.loan.app.service.LoanSacService;

@Service
public class Scanctionimpl implements LoanSacService{
@Autowired ScantionRepository sr;

@Override
public Optional<CustomerDetails> findById(int cusid) {
	return sr.findById(cusid);
	  
}
@Override
public CustomerDetails savesactiondata(CustomerDetails customerDetails) {
	
	return sr.save(customerDetails);
}

}
