package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.dto.AccountCreationDto;
import com.example.gorgeous.pomeranian.service.impl.CreationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreationController {

    @Autowired
    private CreationServiceImpl creator;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AccountCreationDto creationDetail){

        System.out.println(creationDetail.getEmail());
        System.out.println(creationDetail.getUsername());
        System.out.println(creationDetail.getPassword());

        creator.createAccount(creationDetail);

        return new ResponseEntity<>("created", HttpStatus.ACCEPTED);
    }

}
