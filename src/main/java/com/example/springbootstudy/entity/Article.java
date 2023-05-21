package com.example.springbootstudy.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity //엔티티로 저장
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

    protected Article() { //기본 생성자

    }

    public Long getId() {
        return  id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
