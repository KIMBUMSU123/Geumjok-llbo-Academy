package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "album_table")
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String albumName;

    @Column
    private String albumSinger;

    @Column
    private String albumThumbnail;

    @Column
    private String albumReleaseDate;

    @Column
    private int albumLikeCount;

    @Column(unique = true)
    private int albumId;

    //    typeEntity에서 Id값 참조받음
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeEntity typeEntity;
}
