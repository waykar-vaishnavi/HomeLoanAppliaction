package com.loan.app.serviceImpl;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.app.model.CustomerDetails;
import com.loan.app.repository.LoanAppRepository;
import com.loan.app.service.LoanAppService;

@Service
public class LoanAppServiceImpl implements LoanAppService
{
     @Autowired
     private LoanAppRepository loanapprepository;
     
	 @Override
	 public CustomerDetails saveCustomer(String customerDetails, MultipartFile pancard, MultipartFile incomeCertificate,
			                            MultipartFile adharcard, MultipartFile pphoto, MultipartFile ssign, MultipartFile bankpassbook) 
	  {
		
		ObjectMapper mapper = new ObjectMapper();
		try
		{
		   CustomerDetails cd = mapper.readValue(customerDetails,CustomerDetails.class);
		   cd.getCustomerAllDocuments().setPanCard(pancard.getBytes());
		   cd.getCustomerAllDocuments().setIncomeProof(incomeCertificate.getBytes());
		   cd.getCustomerAllDocuments().setAadharCard(adharcard.getBytes());
		   cd.getCustomerAllDocuments().setPhoto(pphoto.getBytes());
		   cd.getCustomerAllDocuments().setSignature(ssign.getBytes());
		   cd.getCustomerAllDocuments().setBankPassBook(bankpassbook.getBytes());
		   loanapprepository.save(cd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDetails> getCustomerData() {
		List<CustomerDetails> cd = loanapprepository.findAll();
		return cd;
	}

	@Override
	public void deleteCustomerById(int csid) {
		loanapprepository.deleteById(csid);
		
	}

	@Override
	public CustomerDetails updateCustomerById(CustomerDetails cd) {
		CustomerDetails emd = loanapprepository.save(cd);
		return emd;
	}

	@Override
	public int checkcibil() {
		int  min=550,max=950;
		int cibil=ThreadLocalRandom.current().nextInt(min,max+1);
		return cibil;
	}

	@Override
	public CustomerDetails getByIdCustomer(int cid) {
		CustomerDetails ccd = loanapprepository.findByCustomerApplicationId(cid);
		return ccd;
	}

	

}
