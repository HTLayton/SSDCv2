package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.dto.LoginDto;
import com.example.gorgeous.pomeranian.entities.Account;
import com.example.gorgeous.pomeranian.repository.AccountRepository;
import com.example.gorgeous.pomeranian.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<String> login (LoginDto loginInfo){
        Account tempAccount = accountRepository.getOne(loginInfo.getUsername());
        if(!tempAccount.isVerified()){
            return new ResponseEntity<>("accountNotVerified", HttpStatus.BAD_REQUEST);
        }
        else if(BCrypt.checkpw(loginInfo.getPassword(), tempAccount.getPasswordHash())){
            tempAccount.setLogOnStatus(true);
            accountRepository.save(tempAccount);
            return getAdminStatus(tempAccount);
        }
        else{
            System.out.println(loginInfo.getUsername());
            System.out.print(loginInfo.getPassword());
            return new ResponseEntity<>("passwordNotMatched", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<String> logoff (String username){
        Account tempAccount = accountRepository.getOne(username);
        tempAccount.setLogOnStatus(false);
        accountRepository.save(tempAccount);
        return new ResponseEntity<String>("logged out", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> getAdminStatus (Account tempAccount){
        if(tempAccount.isAdmin()){
            return new ResponseEntity<String>("isAdmin:true", HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<String>("isAdmin:false", HttpStatus.ACCEPTED);
    }
}
