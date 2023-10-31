package com.icia.musicproject.entity;

import com.icia.musicproject.DTO.MemberDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//
@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "member_table")
@ToString
public class MemberEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String memberNickname;

    @Column(length = 100, nullable = false, unique = true)
    private String memberEmail;

    @Column(length = 100, nullable = false)
    private String memberPw;

    @Column(length = 100, nullable = false)
    private String memberName;

    @Column(length = 100, nullable = false)
    private String memberMobile;

    @Column
    private int memberFileAttached;

    @Column
    private String memberFavorite;

    @Column
    private Date memberDate;

    @Column
    private String memberIdNumber;

    @Column
    private String memberBirth;

    @Column
    private int memberAge;

    //    //   아래부터 참조관계 설정
////   수정 할 때 오류나면 cascade type persist, orphanRemoval false(기본값)로 변경. 삭제 메소드는 그냥 리스트에서 보이지 않는 것으로
//    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<NewsCommentEntity> newsCommentEntityList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<PlaylistEntity> playlistEntityList = new ArrayList<>();
    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPw(memberDTO.getMemberPw());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        memberEntity.setMemberAge(memberDTO.getMemberAge());
        memberEntity.setMemberNickname(memberDTO.getMemberNickname());
        memberEntity.setMemberFavorite(memberDTO.getMemberFavorite());
        return memberEntity;
    }
}