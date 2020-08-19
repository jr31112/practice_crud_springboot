package com.springboot.practice.crud.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 실행자 외에 다른 실행자 실행
// 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = Controller.class) // 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션
// 선언할 경우 @Controller, @ControllerAdvice를 사용할 수 있으며 @Service, @Component, @Repository 는 사용 할 수 없음
public class ControllerTest {
    @Autowired // 스프링이 관리하는 Bean을 주입 받음
    private MockMvc mvc; // 스프링 MVC 테스트의 시작, 이 클래스를 통해 HTTP 메소드에 대해 테스트 실행 가능

    @Test
    public void hello_test() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 Get 요청 실행
                .andExpect(status().isOk()) // Http 200 인지 검증
                .andExpect(content().string(hello)); // 응답 본문의 내용 검증
    }

    @Test
    public void hello_dto_test() throws Exception{
        String name = "kis";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount))) // param은 sting만 사용 가능

                .andExpect(status().isOk()) // Http 200 인지 검증ㅠ
                .andExpect(jsonPath("$.name", is(name))) // 응답 본문의 내용 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}