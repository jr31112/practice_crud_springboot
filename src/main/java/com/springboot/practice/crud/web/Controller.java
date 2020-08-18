package com.springboot.practice.crud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Json을 반환하는 컨트롤러 생성
// 전에는 각 메서드 마다 선언하였지만 한번만 해줘도 됨
public class Controller {
    @GetMapping("/hello") // Get 요청을 받을 수 있는 API 생성
    public String hello(){
        return "hello";
    }
}
