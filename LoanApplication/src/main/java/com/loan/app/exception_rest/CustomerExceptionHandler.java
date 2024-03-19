package com.loan.app.exception_rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loan.app.dto.BaseResponse;
import com.loan.app.enums.ErrorInfo;
import com.loan.app.exception.CustomerNotFound;

@RestControllerAdvice
public class CustomerExceptionHandler {
   
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<BaseResponse> handleCustomerNotFound()
	{
		return new ResponseEntity<BaseResponse>(new BaseResponse(ErrorInfo.Customer_Is_Not_Available.toString(),new Date()),HttpStatus.NOT_FOUND);
	}
}
