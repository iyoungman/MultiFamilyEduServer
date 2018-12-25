package com.cosmos.multifamily.domain.dto;

import com.cosmos.multifamily.domain.entity.Experiment;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by youngman on 2018-12-19.
 */
@Data
public class ExperimentRequestDto {
    @NotEmpty
    private String user;
    @NotEmpty
    private String word;
    @NotEmpty
    private int areascore;
    @NotEmpty
    private int shapescore;

    public Experiment toEntity() {
        return new Experiment(user, word, areascore, shapescore);
    }
}
