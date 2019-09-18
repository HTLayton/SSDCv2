package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.AccountCreationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface CreationService {
    ResponseEntity<String> createAccount(AccountCreationDto creationDetail);
}
