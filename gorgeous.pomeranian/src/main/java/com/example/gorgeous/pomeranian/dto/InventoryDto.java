package com.example.gorgeous.pomeranian.dto;

import com.example.gorgeous.pomeranian.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class InventoryDto {

    @Autowired
    InventoryRepository inventoryRepository;

    private int sku;
    private int quantity;
}
