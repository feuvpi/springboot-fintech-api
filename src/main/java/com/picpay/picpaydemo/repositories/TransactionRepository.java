package com.picpay.picpaydemo.repositories;

import com.picpay.picpaydemo.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
