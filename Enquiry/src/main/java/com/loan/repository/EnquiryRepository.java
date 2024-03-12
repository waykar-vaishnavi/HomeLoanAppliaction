package com.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.model.CustomerEnquiryDetails;

@Repository
public interface EnquiryRepository extends JpaRepository<CustomerEnquiryDetails, Integer>{

}
