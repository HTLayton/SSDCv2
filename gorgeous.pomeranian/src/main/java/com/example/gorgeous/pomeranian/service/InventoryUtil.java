package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.entities.Inventory;
import com.example.gorgeous.pomeranian.repository.InventoryRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryUtil {

    @Autowired
    InventoryRepository inventoryRepository;

    public ResponseEntity<String> getAllInventory(){
        List<Inventory> itemsInDatabase = inventoryRepository.findAll();
        JsonObject itemsAsJson = new JsonObject();
        JsonArray items = new JsonArray();
        for(int i = 0; i < itemsInDatabase.size(); i++){
            Inventory currentItem=itemsInDatabase.get(i);
            JsonObject itemDetails = new JsonObject();
            itemDetails.addProperty("sku", currentItem.getSku());
            itemDetails.addProperty("name", currentItem.getInventoryName());
            itemDetails.addProperty("description", currentItem.getDescription());
            itemDetails.addProperty("quantity", currentItem.getQuantity());
            itemDetails.addProperty("price", currentItem.getPrice());
            itemDetails.addProperty("image_url", currentItem.getImageURL());
            items.add(itemDetails);
        }
        itemsAsJson.add("items", items);
        return new ResponseEntity<String>(itemsAsJson.toString(), HttpStatus.ACCEPTED);
    }
}
