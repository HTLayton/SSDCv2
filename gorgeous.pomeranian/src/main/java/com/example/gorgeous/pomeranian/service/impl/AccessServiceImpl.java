package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.db.ConnectionRepository;
import com.example.gorgeous.pomeranian.dto.LoginDto;
import com.example.gorgeous.pomeranian.entities.Account;
import com.example.gorgeous.pomeranian.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessServiceImpl implements AccessService {
    @Autowired
    ConnectionRepository connectionRepository;

    public void login(LoginDto loginInfo){
        Account tempAccount = connectionRepository.getOne(loginInfo.getUsername());
        tempAccount.setLogOnStatus(true);
        connectionRepository.save(tempAccount);
    }

    public void logoff(String userName){
        Account tempAccount = connectionRepository.getOne(userName);
        tempAccount.setLogOnStatus(false);
        connectionRepository.save(tempAccount);
    }
}
