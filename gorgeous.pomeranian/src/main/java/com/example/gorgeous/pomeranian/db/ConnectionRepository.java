package com.example.gorgeous.pomeranian.db;

import com.example.gorgeous.pomeranian.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<account, String> {

}
