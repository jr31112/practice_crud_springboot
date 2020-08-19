package com.springboot.practice.crud.web;

import com.springboot.practice.crud.web.dto.ResponseDto; // ResponseDto 패키지를 받아서
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Json을 반환하는 컨트롤러 생성
// 전에는 각 메서드 마다 선언하였지만 한번만 해줘도 됨
public class Controller {
    @GetMapping("/hello") // Get 요청을 받을 수 있는 API 생성
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto") // Get 요청 API 생성
    public ResponseDto helloDto(
            @RequestParam("name") String name, // 외부에서 넘긴 파라미터를 가져오는 어노 테이션
            @RequestParam("amount") int amount // (@RequestParam("amount"))라는 이름으로 외부에서 넘긴 파라미터를 메소드 파라미터(int amount)에 저장하게 됨
    ){return new ResponseDto(name, amount);}
}

