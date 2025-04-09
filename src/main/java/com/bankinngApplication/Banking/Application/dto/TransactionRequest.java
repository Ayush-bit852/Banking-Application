package com.bankinngApplication.Banking.Application.dto;

import lombok.Getter;

public class TransactionRequest {
    @Getter
    private String accountNumber;
    private double amount;

    public Object getAmount() {

        return amount;
    }
}
