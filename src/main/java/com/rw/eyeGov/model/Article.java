package com.rw.eyeGov.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Article extends BaseEntity{
    private String title;

    private String description;

    private String cover;

    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    private List<String> categories;

    private Integer applause;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

}
