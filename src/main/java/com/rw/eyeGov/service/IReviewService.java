package com.rw.eyeGov.service;

import com.rw.eyeGov.dto.ReviewDto;
import com.rw.eyeGov.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IReviewService {
    Review createReview(ReviewDto reviewDTO);
    Optional<Review> getReviewById(UUID id);
    Page<Review> getAllArticleReviews(UUID articleId,Pageable pageable);
    Review updateReview(UUID id, ReviewDto reviewDto);
    void deleteReview(UUID id);
}
