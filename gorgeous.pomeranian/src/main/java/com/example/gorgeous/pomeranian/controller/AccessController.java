package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.dto.LoginDto;
import com.example.gorgeous.pomeranian.service.impl.AccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class AccessController{

    @Autowired
    private AccessServiceImpl access;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginInfo){
        return access.login(loginInfo);
    }

    @PostMapping("/logoff/{username}")
    public ResponseEntity<String> logoff(@PathVariable String username){
        return access.logoff(username);
    }
}
