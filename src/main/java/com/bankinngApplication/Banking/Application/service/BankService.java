package com.bankinngApplication.Banking.Application.service;

import com.bankinngApplication.Banking.Application.dto.TransactionRequest;

public interface BankService {
    void deposit(TransactionRequest request);
    void withdraw(TransactionRequest request);
    void transfer(String fromAcc, String toAcc, double amount);
}
