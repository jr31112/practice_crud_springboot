package com.springboot.practice.crud.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
// assertj의 장점
// 1. 추가적인 라이브러리가 필요하지 않다(JUnit과 같은 경우 assertThat을 사용하려면 CoreMatchers 라이브러리가 필요하다)
// 2. wkehddhkstjddl ghkrtlfgl wldnjsdl ehlsek.

public class ResponseDtoTest {

    @Test
    public void lombok_unit_test(){
        // given
        String name = "test";
        int amount = 1000;

        // when
        ResponseDto dto = new ResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // assertj라는 테스트 검증 라이브러리의 검증 메소드
        // 검증 대상을 메소드 인자로 답으며 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용 가능
        // isEqualTo는 동등 비교 메소드로 결과같과 메소드의 인자 값이 비교하여 같을때만 성공
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
