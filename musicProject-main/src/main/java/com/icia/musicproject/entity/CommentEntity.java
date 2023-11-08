package com.icia.musicproject.entity;

import com.icia.musicproject.DTO.CommentDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter(AccessLevel.PRIVATE)
@Getter
@Table(name = "comment_table")
public class CommentEntity {

}
