package com.rw.eyeGov.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ArticleDto {

    private String title;

    private String description;

    private byte[] cover;

    private String content;

    private List<String> categories;

    private String authorName;

    private UUID userId;

    private ELifeCycle state;

    private Integer applause;
}
