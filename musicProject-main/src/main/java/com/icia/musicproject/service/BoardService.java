package com.icia.musicproject.service;

import com.icia.musicproject.DTO.BoardDTO;
import com.icia.musicproject.entity.BoardEntity;
import com.icia.musicproject.entity.MemberEntity;
import com.icia.musicproject.repository.BoardRepository;
import com.icia.musicproject.repository.MemberRepository;
import com.icia.musicproject.util.UtilClass;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;


    public Long save(BoardDTO boardDTO) throws IOException {
        String emailOrNickname = boardDTO.getBoardNickname();  // 닉네임 또는 이메일 값을 가져옴

// 사용자가 이메일을 입력한 경우
        MemberEntity memberEntity = memberRepository.findByMemberEmail(emailOrNickname)
                .orElseGet(() -> memberRepository.findByMemberNickname(emailOrNickname)
                        .orElseThrow(() -> new NoSuchElementException("해당하는 멤버를 찾을 수 없습니다. 입력된 값: " + emailOrNickname)));


        // 나머지 코드는 그대로입니다.

        BoardEntity boardEntity = BoardEntity.toSaveEntity(memberEntity, boardDTO);
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        System.out.println("savedEntity = " + savedEntity);
        return savedEntity.getId();

    }

    public Page<BoardDTO> findAll(int page, String type, String q) {
        page = page - 1;
        int pageLimit = 5;
        Page<BoardEntity> boardEntities = null;
        // 검색인지 구분
        if (q.equals("")) {
            // 일반 페이징
            boardEntities = boardRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
        } else {
            if (type.equals("boardTitle")) {
                boardEntities = boardRepository.findByBoardTitleContaining(q, PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
            } else if (type.equals("boardWriter")) {
                boardEntities = boardRepository.findByBoardWriterContaining(q, PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
            }
        }
        Page<BoardDTO> boardList = boardEntities.map(boardEntity ->
                BoardDTO.builder()
                        .id(boardEntity.getId())
                        .boardTitle(boardEntity.getBoardTitle())
                        .boardWriter(boardEntity.getBoardWriter())
                        .boardNickname(boardEntity.getBoardNickname())
                        .boardHits(boardEntity.getBoardHits())
                        .createdAt(UtilClass.dateTimeFormat(boardEntity.getCreatedAt()))
                        .build());
        return boardList;
    }
}
