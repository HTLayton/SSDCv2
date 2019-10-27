package com.example.gorgeous.pomeranian.dto;

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
    public String toHTMLString(){
        System.out.println("Bouta crash");
        System.out.println(inventoryRepository.findBySku(sku).getInventoryName());
        return "<tr><td>" + inventoryRepository.findBySku(sku).getInventoryName() + "</td><td>" + quantity + "</td></tr>";
    }
}
