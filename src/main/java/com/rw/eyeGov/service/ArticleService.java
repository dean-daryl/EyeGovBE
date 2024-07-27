package com.rw.eyeGov.service;

import com.rw.eyeGov.dto.ArticleDto;
import com.rw.eyeGov.dto.ELifeCycle;
import com.rw.eyeGov.exception.ResourceNotFoundException;
import com.rw.eyeGov.model.Article;
import com.rw.eyeGov.model.User;
import com.rw.eyeGov.repository.IArticleRepository;
import com.rw.eyeGov.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleRepository articleRepository;
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Article createArticle(ArticleDto articleDto) {
        Article article = new Article();
        User user = userRepository.findById(articleDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
        article.setAuthor(user);
        article.setState(ELifeCycle.DRAFT);
        article.setDescription(articleDto.getDescription());
        article.setContent(articleDto.getContent());
        article.setTitle(articleDto.getTitle());
        article.setCategories(articleDto.getCategories());
        article.setCover(articleDto.getCover());
        article.setApplause(0);
       return articleRepository.save(article);
    }

    @Override
    public Optional<Article> getArticleById(UUID id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article updateArticle(UUID id, ArticleDto updatedArticle) {
            Article existingArticle = articleRepository.findById(id).orElseThrow(()-> new RuntimeException("Article Not Found "));
            existingArticle.setTitle(updatedArticle.getTitle());
            existingArticle.setDescription(updatedArticle.getDescription());
            existingArticle.setCover(updatedArticle.getCover());
            existingArticle.setContent(updatedArticle.getContent());
            return articleRepository.save(existingArticle);
    }

    @Override
    public Article applaudArticle(UUID id, Integer numberOfApplause) {
        Article article = articleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Article not found!"));
        article.setApplause(numberOfApplause);
        return  articleRepository.save(article);
    }

    @Override
    public void deleteArticle(UUID id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> fetchArticleByCategory(String category) {
        return  articleRepository.findArticlesByCategory(category);
    }
}
