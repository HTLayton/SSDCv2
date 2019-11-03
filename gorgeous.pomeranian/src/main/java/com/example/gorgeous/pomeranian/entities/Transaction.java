package com.example.gorgeous.pomeranian.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Table("transaction")
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @Column(name = "xyz", nullable = false)
    private int autoGeneratedID;

    @Column(name = "id", nullable = false)
    private int Id;

    @Column(name = "sku", nullable = false)
    private int sku;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "customer_email", nullable = false)
    private String email;

    @Column(name = "order_total", nullable = false)
    private double orderTotal;

    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;
}
