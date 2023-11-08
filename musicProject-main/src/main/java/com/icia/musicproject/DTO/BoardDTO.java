package com.icia.musicproject.DTO;

import com.icia.musicproject.entity.BoardEntity;
import com.icia.musicproject.util.UtilClass;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardTitle;
    private String boardContents;
    private String createdAt;
    private int boardHits;
    private int boardLike;

    //  게시판 사진
//    private List<MultipartFile> boardFile;
//    private int fileAttached;
//    private List<String> originalFileName = new ArrayList<>();
//    private List<String> storedFileName = new ArrayList<>();

    public static BoardDTO toDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setCreatedAt(UtilClass.dateTimeFormat(boardEntity.getCreatedAt()));
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardLike(boardEntity.getBoardLike());

//        if (boardEntity.getFileAttached() == 1) {
//            for (BoardFileEntity boardFileEntity: boardEntity.getBoardFileEntityList()) {
//                boardDTO.getOriginalFileName().add(boardFileEntity.getOriginalFileName());
//                boardDTO.getStoredFileName().add(boardFileEntity.getStoredFileName());
//            }
//            boardDTO.setFileAttached(1);
//        } else {
//            boardDTO.setFileAttached(0);
//        }
//
        return boardDTO;
    }
}














