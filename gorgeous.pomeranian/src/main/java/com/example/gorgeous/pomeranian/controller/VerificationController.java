package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.account;
import com.example.gorgeous.pomeranian.db.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @Autowired
    ConnectionRepository connectionRepository;

    @GetMapping("/send-link")
    public String getLink(){
        return "Test Link";
    }

    @PostMapping("/check/{token}")
    public ResponseEntity<String> checkToken(@PathVariable String token){

        account tempAccount = connectionRepository.getOne(token);
        tempAccount.setVerified(1);
        connectionRepository.save(tempAccount);

        return new ResponseEntity<>("Verified", HttpStatus.ACCEPTED);
    }
}
