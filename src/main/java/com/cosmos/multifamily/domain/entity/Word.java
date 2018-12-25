package com.cosmos.multifamily.domain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 *
 */
@Data
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String word;
}
