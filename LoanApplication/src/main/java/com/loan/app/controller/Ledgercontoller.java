package com.loan.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.app.model.CustomerDetails;
import com.loan.app.model.Ledger;
import com.loan.app.service.Ledgerservice;

@CrossOrigin("*")
@RequestMapping("/ledger")
@RestController
public class Ledgercontoller {
@Autowired Ledgerservice ls;
@PutMapping("/updateledger/{customerApplicationId}")
public ResponseEntity<CustomerDetails> updateledger(@PathVariable("customerApplicationId") int cusid,@RequestBody Ledger ledger)
{
	Optional<CustomerDetails> ledgerbyid=ls.findById(cusid);
	CustomerDetails customerDetails=ledgerbyid.get();
	if(ledgerbyid.isPresent())
	{
		customerDetails.getCustomerLedger().setLedgerId(ledger.getLedgerId());
		customerDetails.getCustomerLedger().setTotalPrincipalAmount(ledger.getTotalPrincipalAmount());
		customerDetails.getCustomerLedger().setMonthlyEMI(ledger.getMonthlyEMI());
		customerDetails.getCustomerLedger().setTenure(ledger.getTenure());
		customerDetails.getCustomerLedger().setLedgerCreatedDate(ledger.getLedgerCreatedDate());
		customerDetails.getCustomerLedger().setNextEmiStartDate(ledger.getNextEmiStartDate());
		customerDetails.getCustomerLedger().setNextEmiEndDate(ledger.getNextEmiEndDate());
		customerDetails.getCustomerLedger().setPreviousEmiStatus(ledger.getPreviousEmiStatus());
		customerDetails.getCustomerLedger().setCurrentMonthEmiStatus(ledger.getCurrentMonthEmiStatus());
		customerDetails.getCustomerLedger().setLoanStatus(ledger.getLoanStatus());
		customerDetails.getCustomerLedger().setRemainingAmount(ledger.getRemainingAmount());
		customerDetails.getCustomerLedger().setAmountPaidtillDate(ledger.getAmountPaidtillDate());
		customerDetails.getCustomerLedger().setPayableAmountwithInterest(ledger.getPayableAmountwithInterest());
		customerDetails.getCustomerLedger().setLoanEndDate(ledger.getLoanEndDate());	
	}
	CustomerDetails savelegder=ls.savecustomerledger(customerDetails);
	return new ResponseEntity<CustomerDetails>(savelegder,HttpStatus.OK);	
}
}
