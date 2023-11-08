package com.icia.musicproject.service;

import com.icia.musicproject.DTO.CommentDTO;
import com.icia.musicproject.entity.BoardEntity;
import com.icia.musicproject.entity.CommentEntity;
import com.icia.musicproject.entity.MemberEntity;
import com.icia.musicproject.repository.BoardRepository;
import com.icia.musicproject.repository.CommentRepository;
import com.icia.musicproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(CommentDTO commentDTO) {
        MemberEntity memberEntity = memberRepository.findByMemberEmail(commentDTO.getCommentWriter()).orElseThrow(() -> new NoSuchElementException());
        BoardEntity boardEntity = boardRepository.findById(commentDTO.getBoardId()).orElseThrow(() -> new NoSuchElementException());
        CommentEntity commentEntity = CommentEntity.toSaveEntity(memberEntity, boardEntity, commentDTO);
        return commentRepository.save(commentEntity).getId();
    }


    /**
     * 댓글 목록을 화면에 출력할 때
     * 로그인한 회원이 좋아요를 한 댓글에는 ♥
     * 좋아요를 하지 않은 댓글에는 ♡ 로 다르게 표시
     */
    @Transactional
    public List<CommentEntity> findAll(Long memberId, Long boardId) {
        BoardEntity boardEntity = (BoardEntity) boardRepository.findById(boardId).orElseThrow(() -> new NoSuchElementException());

        // 해당 게시글의 댓글 목록
        List<CommentEntity> commentEntityList = commentRepository.findByBoardEntityOrderByIdDesc(boardEntity);

        MemberEntity memberEntity = memberRepository.findById(memberId).orElseThrow(() -> new NoSuchElementException());

        // 로그인 회원이 해당 게시글에 좋아요를 한 좋아요 목록
//        List<LikeEntity> likeEntityList = likeRepository.findByMemberEntityAndBoardEntity(memberEntity, boardEntity);
//
//        // 댓글 DTO 변환시 로그인한 회원이 각 댓글에 좋아요를 했냐 안했냐를 따져야 함
        List<CommentDTO> commentDTOList = new ArrayList<>();
        commentEntityList.forEach(comment -> {
            commentDTOList.add(CommentDTO.toDTO(comment));
        });
//
        return commentEntityList;
    }

}