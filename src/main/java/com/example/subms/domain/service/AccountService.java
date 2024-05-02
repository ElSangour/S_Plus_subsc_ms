package com.example.subms.domain.service;

import com.example.subms.domain.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public Account createAccount(Account account) {
        return account;
    }
}
