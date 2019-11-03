package com.example.gorgeous.pomeranian.repository;

import com.example.gorgeous.pomeranian.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = "Select * from inventory where sku = :sku", nativeQuery = true)
    Transaction findBySku(@Param("sku") int sku);

    @Modifying
    @Query(value = "insert into transaction (id,sku,quantity,customer_email,order_total,shipping_address) values (:id,:sku,:quantity,:customer_email,:order_total,:shipping_address)", nativeQuery = true)
    @Transactional
    void insertTransaction(@Param("id") int id, @Param("sku") int sku, @Param("quantity") int quantity, @Param("customer_email") String customer_email, @Param("order_total") double order_total, @Param("shipping_address") String shipping_address);

    @Query(value = "select id from transaction order by id desc limit 1", nativeQuery = true)
    int getRecentId();
}
