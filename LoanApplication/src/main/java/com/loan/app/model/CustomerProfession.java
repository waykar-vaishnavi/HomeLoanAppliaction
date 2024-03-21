package com.loan.app.model;

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
public class CustomerProfession 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int professionId;
	private String professionType;
	private double professionMonthlyIncome;
	private String professionDesignation;
}
