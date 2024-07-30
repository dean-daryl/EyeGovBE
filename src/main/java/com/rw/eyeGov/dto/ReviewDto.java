package com.rw.eyeGov.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReviewDto {
    private String content;
    private int rating;
    private String authorName;
    private UUID userId;
    private UUID articleId;

}
