package com.bankinngApplication.Banking.Application.service;

import com.bankinngApplication.Banking.Application.dto.TransactionRequest;
import com.bankinngApplication.Banking.Application.entity.Account;
import com.bankinngApplication.Banking.Application.entity.Transaction;
import com.bankinngApplication.Banking.Application.repository.AccountRepository;
import com.bankinngApplication.Banking.Application.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final AccountRepository accountRepo;
    private final TransactionRepository transactionRepo;

    @Override
    public void deposit(TransactionRequest request) {
        Account acc = accountRepo.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        acc.getClass(acc.getBalance() + request.getAmount());

        Transaction t = new Transaction();
        t.setAmount(request.getAmount());
        t.setType("DEPOSIT");
        t.setAccount(acc);

        transactionRepo.save(t);
        accountRepo.save(acc);
    }

    @Override
    public void withdraw(TransactionRequest request) {
        Account acc = accountRepo.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (acc.getBalance() < request.getAmount())
            throw new RuntimeException("Insufficient balance");

        acc.setBalance(acc.getBalance() - request.getAmount());

        Transaction t = new Transaction();
        t.setAmount(request.getAmount());
        t.setType("WITHDRAW");
        t.setAccount(acc);

        transactionRepo.save(t);
        accountRepo.save(acc);
    }

    @Override
    public void transfer(String fromAccNum, String toAccNum, double amount) {
        withdraw(new TransactionRequest(fromAccNum, amount));
        deposit(new TransactionRequest(toAccNum, amount));
    }
}
