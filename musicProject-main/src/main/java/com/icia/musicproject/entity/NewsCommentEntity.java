package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
//
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name="newsComment_table")
public class NewsCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String newsComment;

    @Column(nullable = false)
    private int newsCommentLike;

    @Column
    private Date newsCommentDate;

//    memberEntity에서 memberId 참조함
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

//  newsEntity에서 newsId 참조함
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "news_id")
    private NewsEntity newsEntity;
}
