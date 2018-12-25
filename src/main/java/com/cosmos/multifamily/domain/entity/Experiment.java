package com.cosmos.multifamily.domain.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by youngman on 2018-12-19.
 */
@Entity
@Data
public class Experiment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String user;

    @Column(nullable = false)
    @NotEmpty
    private String word;

    @Column(nullable = false)
    @NotEmpty
    private int areascore;

    @Column(nullable = false)
    @NotEmpty
    private int shapescore;

    public Experiment(String user, String word, int areascore, int shapescore) {
        this.user = user;
        this.word = word;
        this.areascore = areascore;
        this.shapescore = shapescore;
    }
}
