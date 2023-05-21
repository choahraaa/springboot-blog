package com.example.springbootstudy.repository;

import com.example.springbootstudy.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {

}
