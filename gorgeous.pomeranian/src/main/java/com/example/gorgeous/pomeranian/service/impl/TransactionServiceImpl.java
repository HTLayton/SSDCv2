package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.dto.InventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import com.example.gorgeous.pomeranian.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public ResponseEntity<String> addInventory(InventoryDto addedItems) {
        return null;
    }

    @Override
    public ResponseEntity<String> purchase(PurchaseDto transactionDetail) {
        return null;
    }
}
