package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.AddInventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import org.springframework.http.ResponseEntity;

public interface TransactionService {

    ResponseEntity<String> addInventory(AddInventoryDto add);

    ResponseEntity<String> purchase(PurchaseDto transactionDetail);
}
