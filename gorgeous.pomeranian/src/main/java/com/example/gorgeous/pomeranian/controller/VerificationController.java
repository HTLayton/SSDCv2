package com.example.gorgeous.pomeranian.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @GetMapping("/send-link")
    public String getLink(){
        return "Test Link";
    }

    @PostMapping("/check/{token}")
    public ResponseEntity<String> checkToken(@PathVariable String token){

        return new ResponseEntity<>("Verified", HttpStatus.ACCEPTED);
    }
}
