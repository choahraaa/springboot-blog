package com.example.springbootstudy.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //엔티티로 저장
@Getter //get 메서드 대신에 사용하는 어노테이션
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자를 생성하는데 별도의 코드 사용없이 가능하게 하는 어노테이션
public class Article {

    @Id //id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키가 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) //'title'이라는 컬럼을 not null 설정
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
