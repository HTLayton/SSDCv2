package com.example.gorgeous.pomeranian.repository;

import com.example.gorgeous.pomeranian.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
