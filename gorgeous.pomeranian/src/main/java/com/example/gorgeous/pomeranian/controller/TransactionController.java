package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.dto.AddInventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import com.example.gorgeous.pomeranian.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionHandler;

    @PutMapping("/add-inventory")
    ResponseEntity<String> addInventory(@RequestBody AddInventoryDto addedItems){
        return transactionHandler.addInventory(addedItems);
    }

    @PostMapping("/purchase")
    ResponseEntity<String> purchase(@RequestBody PurchaseDto orderDetails){
        return transactionHandler.purchase(orderDetails);
    }
}
