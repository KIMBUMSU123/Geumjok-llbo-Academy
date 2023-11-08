package com.icia.musicproject.service;

import com.icia.musicproject.repository.BoardRepository;
import com.icia.musicproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
 //   private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
//    private final LikeRepository likeRepository;

}
