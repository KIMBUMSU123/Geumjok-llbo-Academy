package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//대상 자료가 가수인지, 노래인지, 앨범인지 판별하는 엔티티
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "type_table")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String typeName;
    // songEntity로 참조 됨
    @OneToMany(mappedBy = "typeEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SongEntity> songEntityList = new ArrayList<>();
    // singerEntity로 참조 됨
    @OneToMany(mappedBy = "typeEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SingerEntity> singerEntityList = new ArrayList<>();
    // albumEntity로 참조 됨
    @OneToMany(mappedBy = "typeEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AlbumEntity> albumEntityList = new ArrayList<>();

}
