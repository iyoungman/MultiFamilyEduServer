package com.cosmos.multifamily.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Word {
    @Id
    @Column(name = "wordname")
    private String wordname;

    @Column(nullable = false)
    private String wordlevel;

    @OneToMany(mappedBy = "word")
    private List<WordPassInfo> wordPassInfo;

}
