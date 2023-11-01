package com.icia.musicproject.service;

import com.icia.musicproject.DTO.MemberDTO;
import com.icia.musicproject.entity.MemberEntity;
import com.icia.musicproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        System.out.println("memberEntity = " + memberEntity);
        System.out.println("memberDTO = " + memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public MemberDTO login(MemberDTO memberDTO) {
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
        Optional<MemberEntity> memberEntity =
                memberRepository.findByMemberEmailAndMemberPw(memberDTO.getMemberEmail(), memberDTO.getMemberPw());
        if (memberEntity.isPresent()) {
            //            MemberEntity memberEntity = optionalMemberEntity.get();
            return MemberDTO.toDTO(memberEntity.get());
        } else {
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toDTO(memberEntity));
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        MemberEntity memberEntity = memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        return MemberDTO.toDTO(memberEntity);
    }

    public boolean emailCheck(String memberEmail) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberEmail(memberEmail);
        if (optionalMemberEntity.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
