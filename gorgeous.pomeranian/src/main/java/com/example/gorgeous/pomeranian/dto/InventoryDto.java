package com.example.gorgeous.pomeranian.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class InventoryDto {
    private int sku;
    private int quantity;
}
