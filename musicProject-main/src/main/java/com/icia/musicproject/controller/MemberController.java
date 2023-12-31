package com.icia.musicproject.controller;

import com.icia.musicproject.DTO.MemberDTO;
import com.icia.musicproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/save")
    public String save() {
        return "/member/save";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "/member/login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "redirectURI", defaultValue = "/member/login") String redirectURI,
                        Model model) {
        model.addAttribute("redirectURI", redirectURI);
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session,
                        @RequestParam("redirectURI") String redirectURI) {
//        System.out.println(memberDTO);
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
//            System.out.println("loginResult = " + loginResult);
//            session.setAttribute("loginNickname", memberDTO.getMemberNickname());
            session.setAttribute("loginNickname", loginResult.getMemberNickname());
//            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            session.setAttribute("loginId", loginResult.getId());
//            return "redirect:" + redirectURI;
            return "redirect:/member/main";
        } else {
            return "/member/login";
        }
    }

    @GetMapping("/main")
    public String main(){
        return "/member/main";
    }

    @GetMapping("/myPage")
    public String myPage() {
        return "/member/main";
    }

    // 이메일 중복체크 기능 미완성
    @PostMapping("/dup-check")
    public ResponseEntity emailCheck(@RequestBody MemberDTO memberDTO) {
        boolean result = memberService.emailCheck(memberDTO.getMemberEmail());
        if (result) {
            return new ResponseEntity<>("사용할 수 있는 이메일 입니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("중복된 이메일 입니다.", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/axios/{id}")
    public ResponseEntity detailAxios(@PathVariable("id") Long id) {
        try {
            MemberDTO memberDTO = memberService.findById(id);
            return new ResponseEntity<>(memberDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }


}

