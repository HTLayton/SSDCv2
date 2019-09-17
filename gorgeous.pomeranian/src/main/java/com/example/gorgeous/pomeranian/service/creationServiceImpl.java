package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.AccountCreationDto;
import com.example.gorgeous.pomeranian.entities.Account;
import com.example.gorgeous.pomeranian.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class creationServiceImpl implements creationService {

    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<String> createAccount(AccountCreationDto creationDetail){
        ResponseEntity<String> re = new ResponseEntity<>("created", HttpStatus.ACCEPTED);

        accountRepository.save(new Account(creationDetail.getEmail(),creationDetail.getUsername(),
                creationDetail.getPassword(), false, false));

        String subject = "Gorgeous Pomeranians registration email";
        String body = "Please register your email by clicking the following link:\n\nlocalhost:8080/check/" + creationDetail.getUsername();

        com.example.gorgeous.pomeranian.service.email.sendEmail(creationDetail.getEmail(),subject,body);

        return re;
    }
}
