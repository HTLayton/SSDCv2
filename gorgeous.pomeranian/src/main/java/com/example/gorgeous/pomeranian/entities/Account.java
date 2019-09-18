package com.example.gorgeous.pomeranian.entities;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Id;

@Table("account")
@AllArgsConstructor
@Setter
public class Account {

    @Column(name = "email", nullable = false)
    private String email;

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "log_on_status", nullable = false)
    private boolean logOnStatus;

    @Column(name = "verified", nullable = false)
    private boolean verified;
}
