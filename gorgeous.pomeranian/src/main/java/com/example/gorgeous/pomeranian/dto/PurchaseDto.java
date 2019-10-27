package com.example.gorgeous.pomeranian.dto;

import lombok.Getter;

@Getter
public class PurchaseDto {
    private InventoryDto[] items;
    private double orderTotal;
    private String username;
    private String address;
}
