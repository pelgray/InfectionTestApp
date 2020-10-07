package com.pelgray.InfectionTestApp.repository;

import com.pelgray.InfectionTestApp.domain.VirusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VirusRepository extends CrudRepository<VirusEntity, Integer> {
    Optional<VirusEntity> findByName(@Param("name") String name);
}
