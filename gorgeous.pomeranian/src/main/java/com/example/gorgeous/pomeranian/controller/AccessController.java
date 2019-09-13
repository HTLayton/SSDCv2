package com.example.gorgeous.pomeranian.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class AccessController {

    @PostMapping("/login")
    public static void login(){

    }

    @PostMapping("/logoff/{username}")
    public static void logoff(){

    }
}
