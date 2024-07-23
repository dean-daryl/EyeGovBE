package com.rw.eyeGov.controller;

import com.rw.eyeGov.dto.ReviewDto;
import com.rw.eyeGov.model.Review;
import com.rw.eyeGov.service.IReviewService;
import com.rw.eyeGov.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody ReviewDto reviewDTO) {
        return reviewService.createReview(reviewDTO);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable UUID id) {
        return reviewService.getReviewById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @GetMapping
    public Page<Review> getAllReviews(@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize) {
        return reviewService.getAllReviews(PageUtil.getPageable(pageNumber, pageSize));
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable UUID id, @RequestBody ReviewDto reviewDto) {
        return reviewService.updateReview(id, reviewDto);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable UUID id) {
        reviewService.deleteReview(id);
    }
}
