package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "singer_table")
public class SingerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String singerName;

    @Column(length = 100)
    private String singerThumbnail;

    @Column
    private String singerBirth;

    @Column
    private int singerLikeCount;

    @Column(unique = true)
    private int singerId;

    //    typeEntity에서 Id값 참조받음
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeEntity typeEntity;
}
