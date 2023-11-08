package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "news_table")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String newsName;

    @Column(length = 30, nullable = false)
    private String newsWriter;

    @Column(length = 500, nullable = false)
    private String newsContents;

    @Column(nullable = false)
    private Date newsDate;

    @Column(nullable = false)
    private int newsHits;

    @Column(nullable = false)
    private int newsFileAttached;

    @OneToMany(mappedBy = "newsEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<NewsCommentEntity> newsCommentEntity = new ArrayList<>();

}
