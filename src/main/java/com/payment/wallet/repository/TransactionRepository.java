package com.payment.wallet.repository;

import com.payment.wallet.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByTransactionId(Long transactionId);
}
