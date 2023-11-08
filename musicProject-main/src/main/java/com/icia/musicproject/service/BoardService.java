package com.icia.musicproject.service;

import com.icia.musicproject.DTO.BoardDTO;
import com.icia.musicproject.repository.BoardFileRepository;
import com.icia.musicproject.repository.BoardRepository;
import com.icia.musicproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardFileRepository boardFileRepository;
    private final MemberRepository memberRepository;


}
