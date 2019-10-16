package com.example.gorgeous.pomeranian.service;

import org.springframework.http.ResponseEntity;

public interface CheckService {
    ResponseEntity<String> check(String token);
}
