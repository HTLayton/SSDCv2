package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.db.ConnectionRepository;
import com.example.gorgeous.pomeranian.dto.LoginDto;
import com.example.gorgeous.pomeranian.entities.Account;
import com.example.gorgeous.pomeranian.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    ConnectionRepository connectionRepository;

    public ResponseEntity<String> login(LoginDto loginInfo){
        Account tempAccount = connectionRepository.getOne(loginInfo.getUsername());
        if(!tempAccount.isVerified()){
            return new ResponseEntity<>("accountNotVerified", HttpStatus.BAD_REQUEST);
        }
        if(tempAccount.isLogOnStatus()){
            return new ResponseEntity<String>("alreadyLoggedIn", HttpStatus.BAD_REQUEST);
        }
        else{
            tempAccount.setLogOnStatus(true);
            connectionRepository.save(tempAccount);
            return new ResponseEntity<String>("logged in", HttpStatus.ACCEPTED);
        }

    }

    public ResponseEntity<String> logoff(String userName){
        Account tempAccount = connectionRepository.getOne(userName);
        if(!tempAccount.isLogOnStatus()){
            return new ResponseEntity<String>("notLoggedIn",HttpStatus.BAD_REQUEST);
        }
        else{
            tempAccount.setLogOnStatus(false);
            connectionRepository.save(tempAccount);
            return new ResponseEntity<String>("logged out",HttpStatus.ACCEPTED);
        }
    }
}
