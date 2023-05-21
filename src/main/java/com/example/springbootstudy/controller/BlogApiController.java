package com.example.springbootstudy.controller;

import com.example.springbootstudy.dto.AddArticleRequest;
import com.example.springbootstudy.entity.Article;
import com.example.springbootstudy.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle); //요청한 자원이 성공적으로 생성되고, 저장된 블로그 글 정보를 응답 객체에 담아 전송
    }
}
