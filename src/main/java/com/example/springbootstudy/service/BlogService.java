package com.example.springbootstudy.service;

import com.example.springbootstudy.dto.AddArticleRequest;
import com.example.springbootstudy.dto.UpdateArticleRequest;
import com.example.springbootstudy.entity.Article;
import com.example.springbootstudy.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나, @NotNull 이 붙은 필드의 생성자를 추가하는 어노테이션
@Service //빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest articleRequest) {
        return  blogRepository.save(articleRequest.toEntity()); //data를 entity로 변환해서 레파지토리에 저장하는 메서드
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id)); //조회된 데이터가 없을 때는 예외처리
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
