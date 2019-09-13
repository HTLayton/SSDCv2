package com.example.gorgeous.pomeranian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @GetMapping("/send-link")
    public String getLink(){
        return "Test Link";
    }

    @PostMapping("/check/{token}")
    public static void checkToken(){

    }
}
