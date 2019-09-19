package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.LoginDto;
import org.springframework.http.ResponseEntity;

public interface AccessService {

    ResponseEntity<String> login(LoginDto loginInfo);

    ResponseEntity<String> logoff(String userName);

}
