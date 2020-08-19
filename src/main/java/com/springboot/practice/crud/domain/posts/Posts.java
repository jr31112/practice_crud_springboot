// Getter 만 존재하며 Setter는 쓰지 않는다.
// 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하도록 한다.

package com.springboot.practice.crud.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동 생성 - lombok
@NoArgsConstructor // 기본 생성자 자동 추가 - lombok
@Entity // 테이블과 링크될 클래스임을 나타내는 어노테이션, 기본값으로 카멜케이스를 스네이크케이스로 매칭
public class Posts {
    @Id // pk 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성 규칙 -> 리드미로 정리할 것
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타내며 굳이 선언 안해도 된다.
    // 그러나 기본값 이외에 추가로 변경하고 싶으면 @Column()을 써서 바꾼다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함 - lombok
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
