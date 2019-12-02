package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.service.InventoryUtil;
import com.example.gorgeous.pomeranian.service.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private InventoryUtil inventoryUtil;

    @Autowired
    private JWTUtils jwtUtils;

    @GetMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getHomepage(@RequestHeader(value = "Authorization") String token){
        if(jwtUtils.validateToken(token))
            return inventoryUtil.getAllInventory();
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
