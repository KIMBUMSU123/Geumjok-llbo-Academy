package com.icia.musicproject.entity;

//플레이리스트 목록(플레이리스트 1, 플레이리스트 2 ...) 출력용 Entity

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "playList_table")
public class PlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String playlistName;

    @Column
    private int playlistLength;

//    MemberEntity에서 memberId 참조함
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

}
