package com.example.gorgeous.pomeranian.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class AddInventoryDto {
    private String authorization;
    private InventoryDto[] items;
}
