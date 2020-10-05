package com.pelgray.InfectionTestApp.repository;

import com.pelgray.InfectionTestApp.domain.VirusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VirusRepository extends CrudRepository<VirusEntity, Integer> {
    VirusEntity findByName(@Param("name") String name);
}
