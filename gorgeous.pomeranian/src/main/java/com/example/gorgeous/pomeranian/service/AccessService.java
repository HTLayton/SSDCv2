package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.LoginDto;
import com.example.gorgeous.pomeranian.entities.Account;
import org.springframework.http.ResponseEntity;

public interface AccessService {

    ResponseEntity<String> login(LoginDto loginInfo);

    ResponseEntity<String> logoff(String username);

    ResponseEntity<String> getAdminStatus(Account tempAccount);
}
