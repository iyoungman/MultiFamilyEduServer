package com.cosmos.multifamily.domain.dto;

import com.cosmos.multifamily.domain.entity.Experiment;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * Created by YoungMan on 2018-12-19.
 */

@Getter
@Setter
public class ExperimentRequestDto {
    @NotEmpty
    private String user;

    @NotEmpty
    private String word;

    @NotEmpty
    private int areaScore;

    @NotEmpty
    private int shapeScore;

    public Experiment toEntity() {
        return Experiment.builder()
                .user(user)
                .word(word)
                .areaScore(areaScore)
                .shapeScore(shapeScore)
                .build();
    }
}
