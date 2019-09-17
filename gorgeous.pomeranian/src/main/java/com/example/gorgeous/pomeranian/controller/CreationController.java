package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.dto.AccountCreationDto;
import com.example.gorgeous.pomeranian.entities.Account;
import com.example.gorgeous.pomeranian.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreationController {

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AccountCreationDto creationDetail){

        System.out.println(creationDetail.getEmail());
        System.out.println(creationDetail.getUsername());
        System.out.println(creationDetail.getPassword());

        return new ResponseEntity<>("created", HttpStatus.ACCEPTED);
    }

}
