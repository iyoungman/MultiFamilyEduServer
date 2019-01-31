package com.cosmos.multifamily.domain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by youngman on 2019-01-01.
 */

@Data
@Entity
public class WordPassInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "wordname")
    private Word word;

    @Column(name = "userid")
    private String user;

    public WordPassInfo(Word word, String user) {
        this.word = word;
        this.user = user;
    }
}
