package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.AccountCreationDto;
import org.springframework.http.ResponseEntity;

public interface CreationService {
    ResponseEntity<String> createAccount(AccountCreationDto creationDetail);
}
