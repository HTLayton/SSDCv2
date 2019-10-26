package com.example.gorgeous.pomeranian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/index")
    public String getHomepage(){
        return "index";
    }
}
