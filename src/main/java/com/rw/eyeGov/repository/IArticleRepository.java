package com.rw.eyeGov.repository;

import com.rw.eyeGov.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IArticleRepository extends JpaRepository<Article, UUID> {
}
