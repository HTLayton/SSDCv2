package com.example.gorgeous.pomeranian.repository;

import com.example.gorgeous.pomeranian.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
