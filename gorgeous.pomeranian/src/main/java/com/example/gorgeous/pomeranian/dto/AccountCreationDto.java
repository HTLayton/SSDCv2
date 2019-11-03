package com.example.gorgeous.pomeranian.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountCreationDto {
    private String email;
    private String username;
    private String password;
}
