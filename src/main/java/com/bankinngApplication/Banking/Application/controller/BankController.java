package com.bankinngApplication.Banking.Application.controller;

import com.bankinngApplication.Banking.Application.dto.TransactionRequest;
import com.bankinngApplication.Banking.Application.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
@RequiredArgsConstructor
public class BankController {

    @Autowired
    private final BankService bankService;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody TransactionRequest request) {
        bankService.deposit(request);
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody TransactionRequest request) {
        bankService.withdraw(request);
        return ResponseEntity.ok("Withdraw successful");
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam String fromAcc,
                                           @RequestParam String toAcc,
                                           @RequestParam double amount) {
        bankService.transfer(fromAcc, toAcc, amount);
        return ResponseEntity.ok("Transfer successful");
    }
}
