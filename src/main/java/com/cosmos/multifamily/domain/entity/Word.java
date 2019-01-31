package com.cosmos.multifamily.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by YoungMan on 2019-01-01.
 */

@Entity
@Getter
@Setter
public class Word {
    @Id
    @Column(name = "name")
    private String name;

    @Column(nullable = false)
    private String level;

    @OneToMany(mappedBy = "word")
    private List<WordPassInfo> wordPassInfo;

}
