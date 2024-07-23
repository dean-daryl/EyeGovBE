package com.rw.eyeGov.service;

import com.rw.eyeGov.dto.ArticleDto;
import com.rw.eyeGov.model.Article;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IArticleService {
    Article createArticle(ArticleDto articleDto);
    Optional<Article> getArticleById(UUID id);
    List<Article> getAllArticles();
    Article updateArticle(UUID id, Article article);
    Article applaudArticle(UUID id, Integer numberOfApplause);
    void deleteArticle(UUID id);
}
