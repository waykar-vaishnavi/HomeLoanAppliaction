package com.loan.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.app.model.CustomerDetails;

@Repository
public interface LoanAppRepository extends JpaRepository<CustomerDetails, Integer>{

}
