package com.bankinngApplication.Banking.Application.repository;

import com.bankinngApplication.Banking.Application.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

