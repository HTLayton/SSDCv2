package com.example.gorgeous.pomeranian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String getHomepage(){
        return "index";
    }
}
