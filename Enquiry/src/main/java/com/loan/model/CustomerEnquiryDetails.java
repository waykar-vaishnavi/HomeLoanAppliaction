package com.loan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEnquiryDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerEnquiryId;
    private String customerFirstName;
    private String  customerLastName;
    private String customerPanCard;
    private long customerAadharNumber;
    private String customerEmailId;
    private String customerPassword;
    private long customerMobileNumber;
    private String customerCibilStatus;
    private int customerCibilScore;
}
