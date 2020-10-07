package com.pelgray.InfectionTestApp.repository;

import com.pelgray.InfectionTestApp.domain.DiseaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseRepository extends CrudRepository<DiseaseEntity, Integer> {
}
