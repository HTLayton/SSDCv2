package com.example.gorgeous.pomeranian.dto;

import lombok.Getter;

@Getter
public class PurchaseDto {
    private int sku;
    private int quantity;
    private double orderTotal;
    private String email;
    private String address;
}
