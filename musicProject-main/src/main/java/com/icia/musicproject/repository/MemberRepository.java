package com.icia.musicproject.repository;

import com.icia.musicproject.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    // 추상메서드(abstract method)
    // select * from member_table where member_email = ?
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
//    Optional<MemberEntity> findByMemberNickname(String memberNickname);

    // select * from member_table where member_email = ? and member_password = ?
    Optional<MemberEntity> findByMemberEmailAndMemberPw(String memberEmail, String memberPw);


    Optional<MemberEntity> findByMemberNickname(String memberNickname);
}