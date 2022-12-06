package com.example.deleteok3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {


    public String write(String userName) {
        return userName +"의 리뷰가 등록되었습니다";
    }
}
