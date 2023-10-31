package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//노래 정보 Entity
//장르 Id 추가해야함 (아직 entity를 안만듬)
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "song_table")
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String songName;

    @Column(length = 100)
    private String songArtist;

    @Column(length = 100)
    private String songAlbum;

    @Column(length = 100)
    private String songComposer;

    @Column
    private String songReleaseDate;

    @Column(length = 2000)
    private String songLyrics;

    @Column(length = 200)
    private String songYoutube;

    @Column(length = 200)
    private String songThumbnail;

    @Column(length = 20)
    private String songPlaytime;

    @Column(length = 100)
    private String songGenre;

    @Column
    private int songLikeCount;

    @Column(unique = true)
    private int songId;

//    typeEntity에서 Id값 참조받음
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeEntity typeEntity;

    // songCommentEntity로 songId값 참조해줌
    @OneToMany(mappedBy = "songEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SongCommentEntity> songCommentEntityList = new ArrayList<>();
}

