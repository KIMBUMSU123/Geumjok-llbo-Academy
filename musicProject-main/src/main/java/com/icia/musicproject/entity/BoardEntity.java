package com.icia.musicproject.entity;

import com.icia.musicproject.DTO.BoardDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "board_table")
@ToString
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String boardWriter;

    @Column(length = 20, nullable = false)
    private String boardNickname;

    @Column(length = 50, nullable = false)
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    @Column
    private int boardLike;

    @Column
    private int fileAttached;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;


    // CommentEntity 미완성
//    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CommentEntity> commentEntityList = new ArrayList<>();

    public static BoardEntity toSaveEntity(MemberEntity memberEntity, BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setMemberEntity(memberEntity);

        // boardDTO.getBoardWriter()가 null이면 기본값을 설정 (여기서는 "Anonymous"로 설정)
        boardEntity.setBoardWriter(boardDTO.getBoardWriter() != null ? boardDTO.getBoardWriter() : "Anonymous");

        boardEntity.setBoardNickname(boardDTO.getBoardNickname());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setFileAttached(0);

        return boardEntity;
    }


}
