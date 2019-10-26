package com.example.gorgeous.pomeranian.repository;

import com.example.gorgeous.pomeranian.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = "Select * from inventory where sku = :sku", nativeQuery = true)
    Transaction findBySku(@Param("sku") int sku);
}
