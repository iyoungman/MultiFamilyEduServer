package com.cosmos.multifamily.domain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 *
 */
@Data
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int highscore;

}
