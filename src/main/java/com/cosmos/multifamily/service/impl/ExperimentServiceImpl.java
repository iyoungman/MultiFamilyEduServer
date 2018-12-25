package com.cosmos.multifamily.service.impl;

import com.cosmos.multifamily.domain.dto.ExperimentRequestDto;
import com.cosmos.multifamily.domain.entity.Experiment;
import com.cosmos.multifamily.repository.ExperimentRepository;
import com.cosmos.multifamily.service.ExperimentService;
import org.springframework.stereotype.Service;

/**
 * Created by youngman on 2018-12-19.
 */
@Service
public class ExperimentServiceImpl implements ExperimentService {

    private ExperimentRepository experimentRepository;

    public ExperimentServiceImpl(ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    public void saveExperimentResult(ExperimentRequestDto experimentRequestDto) {
        Experiment experiment = experimentRequestDto.toEntity();
        experimentRepository.save(experiment);
    }
}
