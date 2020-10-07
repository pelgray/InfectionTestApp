package com.pelgray.InfectionTestApp.repository;

import com.pelgray.InfectionTestApp.domain.PopulationEntity;
import org.springframework.data.repository.CrudRepository;

public interface PopulationRepository extends CrudRepository<PopulationEntity, Integer> {
}
