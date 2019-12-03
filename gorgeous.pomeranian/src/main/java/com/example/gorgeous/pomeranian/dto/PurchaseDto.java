package com.example.gorgeous.pomeranian.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PurchaseDto {
    private String authorization;
    private InventoryDto[] items;
    private double orderTotal;
    private String username;
    private String address;
}
