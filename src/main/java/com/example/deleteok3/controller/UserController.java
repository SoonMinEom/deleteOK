package com.example.deleteok3.controller;

import com.example.deleteok3.service.ReviewService;
import com.example.deleteok3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final ReviewService reviewService;

    @PostMapping("/login")
    public ResponseEntity<String> login () {
        String token = userService.login();
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/review")
    public ResponseEntity<String> review(Authentication authentication) {
        log.info("userName : {} ", authentication.getName());
        String review = reviewService.write(authentication.getName());
        return ResponseEntity.ok().body(review);
    }
}
