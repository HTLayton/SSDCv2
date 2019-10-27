package com.example.gorgeous.pomeranian.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Setter;
import javax.persistence.Id;

@Table("inventory")
@Entity
@AllArgsConstructor
@Getter
@Setter
public class Inventory {

    public Inventory(){}

    @Id
    @Column(name = "sku", nullable = false)
    private int sku;

    @Column(name = "name", nullable = false)
    private String inventoryName;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;
}
