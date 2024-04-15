package com.example.subms.infrastructure.config;


import org.killbill.billing.client.KillBillHttpClient;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KillBillConfig {

    @Bean
    public KillBillHttpClient killBillHttpClient() {
        return new KillBillHttpClient("http://127.0.0.1:8000", "admin", "password", "bob", "lazar");
    }
}
