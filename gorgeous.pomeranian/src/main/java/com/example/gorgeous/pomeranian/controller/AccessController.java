package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.dto.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/access")
public class AccessController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginInfo){

        System.out.println(loginInfo.getUsername());
        System.out.println(loginInfo.getPassword());
        return new ResponseEntity<>("logged in",HttpStatus.ACCEPTED);
    }

    @PostMapping("/logoff/{username}")
    public ResponseEntity<String> logoff(@PathVariable String username){

        System.out.println(username);
        return new ResponseEntity<>("logged out", HttpStatus.ACCEPTED);
    }
}
