package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter(AccessLevel.PRIVATE)
@Getter
@Table(name = "board_file_table")
public class BoardFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    public static BoardFileEntity toSaveBoardFile(BoardEntity savedEntity, String originalFilename, String storedFileName) {
        BoardFileEntity boardFileEntity = new BoardFileEntity();
        boardFileEntity.setOriginalFileName(originalFilename);
        boardFileEntity.setStoredFileName(storedFileName);
        boardFileEntity.setBoardEntity(savedEntity);
        return boardFileEntity;
    }
}
