package com.example.gorgeous.pomeranian.service.impl;

import com.example.gorgeous.pomeranian.dto.AccountCreationDto;
import com.example.gorgeous.pomeranian.entities.Account;
import com.example.gorgeous.pomeranian.repository.AccountRepository;
import com.example.gorgeous.pomeranian.service.CreationService;
import com.example.gorgeous.pomeranian.service.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CreationServiceImpl implements CreationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private email emailer;

    @Transactional
    public ResponseEntity<String> createAccount(AccountCreationDto creationDetail){

        if (accountRepository.findByEmail(creationDetail.getEmail()).size() != 0) {
            return new ResponseEntity<>("emailExists", HttpStatus.NOT_ACCEPTABLE);
        } else if(accountRepository.findByUsernameList(creationDetail.getUsername()).size() != 0){
            return new ResponseEntity<>("usernameExists",HttpStatus.NOT_ACCEPTABLE);
        } else{
            String encryptedPassword = BCrypt.hashpw(creationDetail.getPassword(), BCrypt.gensalt());
            accountRepository.save(new Account(creationDetail.getEmail(), creationDetail.getUsername(),
                    encryptedPassword, false, false,false));
            String subject = "Gorgeous Pomeranians registration email";
            String body = "Please register your email by clicking the following link:\n\nhttp://localhost:3000/verify/" + creationDetail.getUsername();

            emailer.sendEmail(creationDetail.getEmail(),subject,body);
            return new ResponseEntity<>("created", HttpStatus.ACCEPTED);
        }
    }
}
