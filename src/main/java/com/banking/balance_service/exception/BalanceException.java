package com.banking.balance_service.exception;

import org.springframework.http.HttpStatus;

public class BalanceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4041123841579092115L;
	private HttpStatus httpStatus;
	private String message;
	
	public BalanceException(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
