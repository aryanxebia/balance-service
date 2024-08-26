package com.banking.balance_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BalanceExcpetionHandler {

	@ExceptionHandler(value = { BalanceException.class })
	ResponseEntity<Object> handleBalanceException(BalanceException balanceException) {
		return ResponseEntity.status(balanceException.getHttpStatus())
				.body(balanceException.getMessage());
	}
}
