package com.example.deleteok3.controller;

import com.example.deleteok3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login () {
        String token = userService.login();
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/review")
    public ResponseEntity<String> review() {
        return ResponseEntity.ok().body("리뷰 등록 권한 획득 완료");
    }
}
