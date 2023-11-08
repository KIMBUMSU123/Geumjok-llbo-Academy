package com.icia.musicproject.DTO;

import com.icia.musicproject.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberDTO {
    private Long id;
    private String memberNickname;
    private String memberEmail;
    private String memberPw;
    private String memberName;
    private String memberMobile;
    private int memberFileAttached;
    private String memberFavorite;
    private Date memberDate;
    private String memberIdNumber;
    private String memberBirth;
    private int memberAge;

    public static MemberDTO toDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberNickname(memberEntity.getMemberNickname());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPw(memberEntity.getMemberPw());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberBirth(memberEntity.getMemberBirth());
        memberDTO.setMemberMobile(memberEntity.getMemberMobile());
        memberDTO.setMemberFavorite(memberEntity.getMemberFavorite());
        memberDTO.setMemberAge(memberEntity.getMemberAge());
        return memberDTO;
    }

}
