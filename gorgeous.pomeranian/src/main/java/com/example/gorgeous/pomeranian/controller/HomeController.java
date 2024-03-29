package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.service.InventoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    InventoryUtil inventoryUtil;

    @GetMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHomepage(){
        return inventoryUtil.getAllInventory();
    }
}
