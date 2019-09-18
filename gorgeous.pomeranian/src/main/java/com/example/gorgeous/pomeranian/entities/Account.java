package com.example.gorgeous.pomeranian.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Setter;
import javax.persistence.Id;

@Table("account")
@Entity
@AllArgsConstructor
@Getter
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

    public Account(){}
}
