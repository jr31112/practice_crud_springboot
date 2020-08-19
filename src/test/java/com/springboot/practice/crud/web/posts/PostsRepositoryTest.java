package com.springboot.practice.crud.web.posts;

import com.springboot.practice.crud.domain.posts.Posts;
import com.springboot.practice.crud.domain.posts.PostsRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위 테스트가 끝날 때 마다 수행되는 메소드 지정
    public void cleanup() {
        postsRepository.deleteAll();
    }

    // CRUD => CR
    @Test
    public void create_read() {
        // given
        String title = "테스트 제목";
        String content = "테스트 본문";
        // posts 테이블에 insert/update 쿼리 실행
        // id값이 있으면 update, 없으면 insert
        postsRepository.save(Posts.builder().title(title)
                                            .content(content)
                                            .author("jr435@naver.com")
                                            .build());

        // when
        // 모든 게시물을 가져오는 메소드인 findAll()이 사용
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        // 이건 진짜 개 쩐다...(갓갓 ORM)
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
