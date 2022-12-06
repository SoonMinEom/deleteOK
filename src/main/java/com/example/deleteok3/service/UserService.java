package com.example.deleteok3.service;

import com.example.deleteok3.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${jwt.token.secret}")
    private String secretKey;

    public String login() {
        return JwtTokenUtil.createToken(secretKey);
    }
}
