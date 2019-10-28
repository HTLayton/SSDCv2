package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.dto.InventoryDto;
import com.example.gorgeous.pomeranian.dto.PurchaseDto;
import com.example.gorgeous.pomeranian.entities.Inventory;
import com.example.gorgeous.pomeranian.repository.AccountRepository;
import com.example.gorgeous.pomeranian.repository.InventoryRepository;
import com.example.gorgeous.pomeranian.repository.TransactionRepository;
import com.example.gorgeous.pomeranian.service.TransactionService;
import com.example.gorgeous.pomeranian.service.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private email emailer;

    @Override
    public ResponseEntity<String> addInventory(InventoryDto[] addedItems) {
        for (InventoryDto item:addedItems) {
            Inventory inventory = inventoryRepository.findBySku(item.getSku());
            int newQuantity = item.getQuantity() + inventory.getQuantity();
            if (newQuantity > 9999) {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            } else {
                inventory.setQuantity(newQuantity);
                inventoryRepository.save(inventory);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> purchase(PurchaseDto transactionDetail) {
        if(accountRepository.isVerified(transactionDetail.getUsername()) == 1) {
            InventoryDto[] currentItems = transactionDetail.getItems();
            if (isValid(currentItems, transactionDetail.getOrderTotal())) {
                int tempId = transactionRepository.getRecentId() + 1;
                for (InventoryDto currentItem : currentItems) {
                    removeFromInventory(currentItem);
                    addToTransaction(tempId, currentItem, transactionDetail);
                }
                String body = emailer.toHTMLString(transactionDetail);
                email.sendHTMLEmail(accountRepository.findByUsernameEmail(transactionDetail.getUsername()), "Successful Gorgeous Pomeranians Order", body);
            } else {
                System.out.println("Purchase Fail");
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            System.out.println("Purchase Complete");
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        System.out.println("Purchase Fail");
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    private double getPrice(InventoryDto currentItem){
        Inventory item = inventoryRepository.findBySku(currentItem.getSku());
        return item.getPrice();
    }

    private boolean checkQuantity(InventoryDto currentItem){
        Inventory item = inventoryRepository.findBySku(currentItem.getSku());
        return item.getQuantity() >= currentItem.getQuantity();
    }

    private boolean isValid(InventoryDto[] currentItems, double orderTotal){
        double total = 0;
        for (InventoryDto currentItem : currentItems) {
            if (!checkQuantity(currentItem)) {
                return false;
            }
            total += getPrice(currentItem);
        }
        return total == orderTotal;
    }

    private void removeFromInventory(InventoryDto currentItem){
        Inventory item = inventoryRepository.findBySku(currentItem.getSku());
        int newQuantity = item.getQuantity()-currentItem.getQuantity();
        item.setQuantity(newQuantity);
        inventoryRepository.save(item);
    }

    private void addToTransaction(int id, InventoryDto currentItem, PurchaseDto currentPurchase){
        String tempEmail = accountRepository.findByUsernameEmail(currentPurchase.getUsername());
        int tempSku = currentItem.getSku();
        int tempQuant = currentItem.getQuantity();
        double tempTot = currentPurchase.getOrderTotal();
        String tempAddr = currentPurchase.getAddress();
        transactionRepository.insertTransaction(id, tempSku, tempQuant, tempEmail, tempTot, tempAddr);
    }
}
