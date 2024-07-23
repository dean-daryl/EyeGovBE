package com.rw.eyeGov.service;

import com.rw.eyeGov.dto.ReviewDto;
import com.rw.eyeGov.model.Article;
import com.rw.eyeGov.model.Review;
import com.rw.eyeGov.model.User;
import com.rw.eyeGov.repository.IArticleRepository;
import com.rw.eyeGov.repository.IReviewRepository;
import com.rw.eyeGov.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private IReviewRepository reviewRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IArticleRepository articleRepository;

    @Override
    public Review createReview(ReviewDto reviewDto) {
        User author = userRepository.findUserByEmail(reviewDto.getAuthorEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Article article = articleRepository.findById(reviewDto.getArticleId())
                .orElseThrow(() -> new RuntimeException("Article not found"));

        Review review = new Review();
        review.setContent(reviewDto.getContent());
        review.setRating(reviewDto.getRating());
        review.setAuthor(author);
        review.setArticle(article);
       return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(UUID id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Page<Review> getAllReviews(Pageable pageable) {
        return reviewRepository.findAll(pageable);

    }

    @Override
    public Review updateReview(UUID id, ReviewDto reviewDto) {
        return reviewRepository.findById(id).map(review -> {
            User author = userRepository.findUserByEmail(reviewDto.getAuthorEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            Article article = articleRepository.findById(reviewDto.getArticleId())
                    .orElseThrow(() -> new RuntimeException("Article not found"));

            review.setContent(reviewDto.getContent());
            review.setRating(reviewDto.getRating());
            review.setAuthor(author);
            review.setArticle(article);
            return reviewRepository.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @Override
    public void deleteReview(UUID id) {
        reviewRepository.deleteById(id);
    }
}
