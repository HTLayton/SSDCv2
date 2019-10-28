package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.InventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import org.springframework.http.ResponseEntity;

public interface TransactionService {

    ResponseEntity<String> addInventory(InventoryDto[] addedItems);

    ResponseEntity<String> purchase(PurchaseDto transactionDetail);
}
