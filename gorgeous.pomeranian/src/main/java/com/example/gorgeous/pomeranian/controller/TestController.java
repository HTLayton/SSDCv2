package com.example.gorgeous.pomeranian.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class TestController {

    @GetMapping("/test/200")
    public ResponseEntity success(){
        return new ResponseEntity("Success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/test/302")
    public ResponseEntity redirectFound(){
        return new ResponseEntity("Redirect Found", HttpStatus.FOUND);
    }

    @GetMapping("/test/418")
    public ResponseEntity teapot(){
        return new ResponseEntity("I'm A Teapot", HttpStatus.I_AM_A_TEAPOT);
    }
}
