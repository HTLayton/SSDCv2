package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.dto.AddInventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import com.example.gorgeous.pomeranian.service.JWTUtils;
import com.example.gorgeous.pomeranian.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private TransactionServiceImpl transactionHandler;

    @PutMapping("/add-inventory")
    ResponseEntity<String> addInventory(@RequestHeader (value = "Authorization") String token,
                                        @RequestBody AddInventoryDto addedItems){
        if(jwtUtils.validateToken(token))
            return transactionHandler.addInventory(addedItems);
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/purchase")
    ResponseEntity<String> purchase(@RequestHeader (value = "Authorization") String token,
                                    @RequestBody PurchaseDto orderDetails){
        if(jwtUtils.validateToken(token))
            return transactionHandler.purchase(orderDetails);
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
