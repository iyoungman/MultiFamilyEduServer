package com.cosmos.multifamily.repository;

import com.cosmos.multifamily.domain.entity.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by youngman on 2018-12-19.
 */
public interface ExperimentRepository extends JpaRepository<Experiment, Long> {

}
