package com.icia.musicproject.service;

import com.icia.musicproject.DTO.MemberDTO;
import com.icia.musicproject.entity.MemberEntity;
import com.icia.musicproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public boolean login(MemberDTO memberDTO) {
/*
DB에서 로그인하는 사용자의 이메일로 조회한 결과를 가져와서
비밀번호가 일치하는지 비교한 뒤 로그인 성공 여부를 판단

findByMemberEmail()
select * from member_table where member_email = ?

findById()
=> select * from member_table where id = ?
*/
// 1.
//        MemberEntity memberEntity = memberRepository.findByMemberEmail(memberDTO.getMemberEmail())
//                                                    .orElseThrow(() -> new NoSuchElementException());
// 2. email, password 둘다 만족하는 조회결과가 있다면 로그인성공, 없다면 로그인실패
        Optional<MemberEntity> optionalMemberEntity =
                memberRepository.findByMemberEmailAndMemberPw(memberDTO.getMemberEmail(), memberDTO.getMemberPw());
        if (optionalMemberEntity.isPresent()) {
            //            MemberEntity memberEntity = optionalMemberEntity.get();
            return true;
        } else {
            return false;
        }
    }
}
