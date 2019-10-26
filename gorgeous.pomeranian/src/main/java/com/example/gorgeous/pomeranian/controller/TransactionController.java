package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.dto.InventoryDto;
import com.example.gorgeous.pomeranian.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionHandler;

    @PutMapping("/add-inventory")
    ResponseEntity<String> addInventory(@RequestBody InventoryDto addedItems){
        return transactionHandler.addInventory(addedItems);
    }
}
