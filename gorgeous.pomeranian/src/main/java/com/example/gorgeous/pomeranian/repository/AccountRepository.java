package com.example.gorgeous.pomeranian.repository;

import com.example.gorgeous.pomeranian.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query(value = "Select * from account where email = :email", nativeQuery = true)
    List<Account> findByEmail(@Param("email") String email);

    @Query(value = "Select * from account where username = :username", nativeQuery = true)
    List<Account> findByUsernameList(@Param("username") String username);

    @Query(value = "Select email from account where username = :username limit 1", nativeQuery = true)
    String findByUsernameEmail(@Param("username") String username);

}
