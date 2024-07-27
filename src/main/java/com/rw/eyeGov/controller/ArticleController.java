package com.rw.eyeGov.controller;

import com.rw.eyeGov.dto.ArticleDto;
import com.rw.eyeGov.model.Article;
import com.rw.eyeGov.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping
    public Article createArticle(@RequestBody ArticleDto articleDto) {
        return articleService.createArticle(articleDto);
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable UUID id) {
        return articleService.getArticleById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable UUID id, @RequestBody ArticleDto articleDto) {
       return articleService.updateArticle(id, articleDto);
    }

    @PatchMapping("/{id}/applause")
    public Article applaudArticle(@PathVariable UUID id, @RequestParam Integer numberOfApplause) {
        return articleService.applaudArticle(id, numberOfApplause);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable UUID id) {
        articleService.deleteArticle(id);
    }
}
