package com.banking.balance_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.banking.balance_service.service.BalanceService;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final WebClient webClient;

    @Autowired
    public BalanceServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.sandbox.transferwise.tech/v1/borderless-accounts/balance-currencies").build();
    }

    @Override
    public String getBalanceFromThirdParty() {
        return webClient.get()
                        .uri("")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer c8923380-d144-45dc-b783-bd3e699d05e6")
                        .header(HttpHeaders.COOKIE, "__cf_bm=DMY3_L2xrAwe9d9JXM3r6HMNazTSUWV2zOXEmyf9NEs-1724659342-1.0.1.1-e1qYv2wHl8EiC2mD_2IgYIJSP.B4rvQfqsqFRR_mS_9ShC9nAZAC9mr2oGPJp2PvSUs.vZw.Rcr2Z5iVCTWKoA") 
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
    }
}
