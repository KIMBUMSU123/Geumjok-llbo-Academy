package com.icia.musicproject.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "query_table")
public class QueryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String queryName;

    @Column
    private int queryCount;
}
