package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.entities.Account;
import com.example.gorgeous.pomeranian.repository.AccountRepository;
import com.example.gorgeous.pomeranian.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<String> check(String token){
        if(!accountRepository.existsById(token)) {
            return new ResponseEntity<>("noAccountExists", HttpStatus.BAD_REQUEST);
        } else if(accountRepository.getOne(token).isVerified()){
            return new ResponseEntity<>("alreadyVerified", HttpStatus.BAD_REQUEST);
        } else{
            Account tempAccount = accountRepository.getOne(token);
            tempAccount.setVerified(true);
            accountRepository.save(tempAccount);
            return new ResponseEntity<>("Verified", HttpStatus.ACCEPTED);
        }
    }
}
