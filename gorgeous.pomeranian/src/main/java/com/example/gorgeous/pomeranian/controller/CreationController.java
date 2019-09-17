package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.db.ConnectionRepository;
import com.example.gorgeous.pomeranian.dto.AccountCreationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreationController {

    @Autowired
    ConnectionRepository connectionRepository;

    @GetMapping("/create/{email}")
    public void getEmail(@PathVariable String email){
        System.out.print(connectionRepository.getOne(email));
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AccountCreationDto creationDetail){

        //System.out.println(creationDetail.getEmail());
        //System.out.println(creationDetail.getUsername());
        //System.out.println(creationDetail.getPassword());
        return new ResponseEntity<>("created", HttpStatus.ACCEPTED);
    }

}
