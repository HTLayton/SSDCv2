package com.example.gorgeous.pomeranian;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="account", schema="account")
public class account {
    @Id
    @Column(name="email")
    private String email;
    @Column(name="user_name")
    private String userName;
    @Column(name="password_hash")
    private String passwordHash;
    @Column(name="log_on_status")
    private int logOnStatus;
    @Column(name="verified")
    private int verified;




    public account() {}

    public account(String email,String userName,String passwordHash, int logOnStatus, int verified){
        this.setEmail(email);
        this.setUserName(userName);
        this.setPasswordHash(passwordHash);
        this.setLogOnStatus(logOnStatus);
        this.setVerified(verified);
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getPasswordHash(){
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash){
        this.passwordHash = passwordHash;
    }
    public int getLogOnStatus(){
        return logOnStatus;
    }

    public void setLogOnStatus(int logOnStatus){
        this.logOnStatus = logOnStatus;
    }
    public int getVerified(){
        return verified;
    }

    public void setVerified(int verified){
        this.verified = verified;
    }

    @Override
    public String toString(){
        return "Account{email=" + email + ",userName=" + userName + ",passwordHash=" + passwordHash + ",logOnStatus=" + logOnStatus + ",Verified=" + verified;
    }
}
