package com.loan.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.ad.model.EmployeeDetails;

@Repository
public interface AdminRepository extends JpaRepository<EmployeeDetails, Integer> {

	public EmployeeDetails findByEmployeeName(String employeeName);
	
}
