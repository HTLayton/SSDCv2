package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.service.impl.CheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @Autowired
    CheckServiceImpl checkService;

    @GetMapping("/send-link")
    public String getLink(){
        return "Test Link";
    }

    @PostMapping("/check/{token}")
    public ResponseEntity<String> checkToken(@PathVariable String token){
        return checkService.check(token);
    }
}
