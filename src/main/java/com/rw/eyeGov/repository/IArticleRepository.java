package com.rw.eyeGov.repository;

import com.rw.eyeGov.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IArticleRepository extends JpaRepository<Article, UUID> {
    @Query(value = "SELECT * FROM article WHERE :categoryName = ANY(categories)", nativeQuery = true)
    List<Article> findArticlesByCategory(@Param("categoryName") String categoryName);
}
