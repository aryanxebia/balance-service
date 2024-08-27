package com.banking.balance_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.balance_service.service.BalanceService;

@RestController
@RequestMapping("/api/v1/")
public class BalanceController {

    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("balance-countries")
    public ResponseEntity<String> getBalance() {
        String balance = balanceService.getBalanceFromThirdParty();
        return ResponseEntity.ok(balance);
    }
}
