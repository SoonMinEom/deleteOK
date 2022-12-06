package com.example.deleteok3.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {
    public static Claims extractToken(String token, String key) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    public static boolean isExpired(String token, String key) {
        return extractToken(token, key).getExpiration().before(new Date());
    }

    public static String createToken(String key) {
        Claims claim = Jwts.claims();
        claim.put("userName","soomin");
        claim.put("userRole","USER");
        return Jwts.builder()
                .setClaims(claim)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+600000))
                .signWith(SignatureAlgorithm.HS256, key).compact();

    }
}
