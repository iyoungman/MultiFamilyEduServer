package com.cosmos.multifamily.controller;

import com.cosmos.multifamily.domain.dto.ExperimentRequestDto;
import com.cosmos.multifamily.service.ExperimentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by youngman on 2018-12-19.
 */
@RestController
public class ExperimentController {

    private ExperimentService experimentService;

    public ExperimentController(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @RequestMapping(value = "multifamily/experiment", method = RequestMethod.POST)
    public void saveExperimentResult(@Valid() @RequestBody ExperimentRequestDto experimentRequestDto) {
        experimentService.saveExperimentResult(experimentRequestDto);
    }
}
