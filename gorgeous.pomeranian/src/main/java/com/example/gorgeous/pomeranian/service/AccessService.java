package com.example.gorgeous.pomeranian.service;

import com.example.gorgeous.pomeranian.dto.LoginDto;

public interface AccessService {

    void login(LoginDto loginInfo);

    void logoff(String userName);

}
