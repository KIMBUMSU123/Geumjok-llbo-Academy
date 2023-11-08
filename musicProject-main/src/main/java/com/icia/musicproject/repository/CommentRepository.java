package com.icia.musicproject.repository;

//import com.icia.musicproject.entity.BoardEntity;
import com.icia.musicproject.entity.BoardEntity;
import com.icia.musicproject.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByBoardEntityOrderByIdDesc(BoardEntity boardEntity);
}