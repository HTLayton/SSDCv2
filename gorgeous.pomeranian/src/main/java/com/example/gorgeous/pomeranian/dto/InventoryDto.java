package com.example.gorgeous.pomeranian.dto;

import com.example.gorgeous.pomeranian.entities.Inventory;
import com.example.gorgeous.pomeranian.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Getter
public class InventoryDto {

    @Autowired
    InventoryRepository inventoryRepository;

    private int sku;
    private int quantity;
}
