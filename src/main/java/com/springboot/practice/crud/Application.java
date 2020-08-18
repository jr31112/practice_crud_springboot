// 패키지란  비슷한 성격의 자바 클래스들을 모아 넣는 자바의 디렉토리
package com.springboot.practice.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정, 여기서 부터 설정을 읽어가기 때문제 프로젝트의 최상단에 위치 해야함
// 프로젝트의 메인 클래스
public class Application {
    public static void main(String[] args) {
        // 내장 WAS(tomcat) 사용
        SpringApplication.run(Application.class, args);
    }
}