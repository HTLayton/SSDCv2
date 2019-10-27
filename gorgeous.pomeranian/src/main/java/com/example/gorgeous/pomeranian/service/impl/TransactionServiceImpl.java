package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.dto.InventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import com.example.gorgeous.pomeranian.entities.Inventory;
import com.example.gorgeous.pomeranian.repository.AccountRepository;
import com.example.gorgeous.pomeranian.repository.InventoryRepository;
import com.example.gorgeous.pomeranian.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public ResponseEntity<String> addInventory(InventoryDto addedItems) {
        Inventory inventory = inventoryRepository.findBySku(addedItems.getSku());
        int newQuantity = addedItems.getQuantity() + inventory.getQuantity();
        if(newQuantity > 9999){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            inventory.setQuantity(newQuantity);
            inventoryRepository.save(inventory);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }

    @Override
    public ResponseEntity<String> purchase(PurchaseDto transactionDetail) {
        InventoryDto[] currentItems = transactionDetail.getItems();
        if(isValid(currentItems, transactionDetail.getOrderTotal())){
            for(int i = 0; i < currentItems.length; i++){
                removeFromInventory(currentItems[i]);
            }
            //TODO send email when purchase completes
            //com.example.gorgeous.pomeranian.service.email.sendEmail(accountRepository.findByUsernameEmail(transactionDetail.getUsername()),"Successful Gorgeous Pomeranians Order", transactionDetail.toString());
        }
        else{
            System.out.println("Purchase Fail");
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        System.out.println("Purchase Complete");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private double getPrice(InventoryDto currentItem){
        Inventory item = inventoryRepository.findBySku(currentItem.getSku());
        return item.getPrice();
    }

    private boolean checkQuantity(InventoryDto currentItem){
        Inventory item = inventoryRepository.findBySku(currentItem.getSku());
        if(item.getQuantity() < currentItem.getQuantity()){
            return false;
        }
        else
            return true;
    }

    private boolean isValid(InventoryDto[] currentItems, double orderTotal){
        double total = 0;
        for(int i = 0; i < currentItems.length; i++){
            if(!checkQuantity(currentItems[i])){
                return false;
            }
            total+=getPrice(currentItems[i]);
        }
        if(total != orderTotal){
            return false;
        }
        return true;
    }

    private void removeFromInventory(InventoryDto currentItem){
        Inventory item = inventoryRepository.findBySku(currentItem.getSku());
        int newQuantity = item.getQuantity()-currentItem.getQuantity();
        item.setQuantity(newQuantity);
        inventoryRepository.save(item);
    }
}
