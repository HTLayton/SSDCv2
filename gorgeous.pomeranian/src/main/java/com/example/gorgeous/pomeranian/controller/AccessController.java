package com.example.gorgeous.pomeranian.controller;

import com.example.gorgeous.pomeranian.db.ConnectionRepository;
import com.example.gorgeous.pomeranian.dto.LoginDto;
import com.example.gorgeous.pomeranian.service.impl.AccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private AccessServiceImpl access;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginInfo){

        //System.out.println(loginInfo.getUsername());
        //System.out.println(loginInfo.getPassword());

        return access.login(loginInfo);
    }

    @PostMapping("/logoff/{username}")
    public ResponseEntity<String> logoff(@PathVariable String username){

        //System.out.println(username);

        return access.logoff(username);
    }
}
