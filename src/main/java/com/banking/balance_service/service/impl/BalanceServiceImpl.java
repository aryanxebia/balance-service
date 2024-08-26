package com.banking.balance_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.banking.balance_service.service.BalanceService;
import com.banking.balance_service.util.ConstantUtils;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final WebClient webClient;
    
    

    @Autowired
    public BalanceServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(ConstantUtils.baseUrl).build();
    }

    @Override
    public String getBalanceFromThirdParty() {
        return webClient.get()
                        .uri("")
                        .header(HttpHeaders.AUTHORIZATION, ConstantUtils.bearerToken)
                        .header(HttpHeaders.COOKIE, ConstantUtils.headerCookie) 
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
    }
}