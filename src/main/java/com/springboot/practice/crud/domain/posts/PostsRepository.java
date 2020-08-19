// DAO 역할(DB Layer 접근자)
// 인터페이스 생성후 JpaRepository<Entity 클래스, Pk 타입>을 상속

package com.springboot.practice.crud.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{}
