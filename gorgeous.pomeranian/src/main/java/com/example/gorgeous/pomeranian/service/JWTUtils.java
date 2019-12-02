package com.example.gorgeous.pomeranian.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTUtils {

    public String createToken(){
        Date date = new Date();
        Date expDate = new Date(System.currentTimeMillis()+5*60*1000);
        String token;
        try {
            Algorithm algorithm = Algorithm.HMAC256("pomeranians");
            token = JWT.create()
                    .withIssuer("Gorgeous Pomeranians")
                    .withIssuedAt(date)
                    .withExpiresAt(expDate)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            token = "Token Not Made";
            System.out.println("Token Not Made");
        }
        return token;
    }

    public boolean validateToken(String token){
        boolean valid;
        try {
            Algorithm algorithm = Algorithm.HMAC256("pomeranians");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("Gorgeous Pomeranians")
                    .acceptExpiresAt(15)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            valid = true;
        } catch (JWTVerificationException exception){
            valid = false;
        }
        return valid;
    }
}
