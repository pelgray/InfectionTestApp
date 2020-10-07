package com.pelgray.InfectionTestApp.controller;

import com.pelgray.InfectionTestApp.domain.DiseaseEntity;
import com.pelgray.InfectionTestApp.domain.VirusEntity;
import com.pelgray.InfectionTestApp.exceptions.VirusesNotFoundException;
import com.pelgray.InfectionTestApp.repository.DiseaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class DiseaseController {
    private static final Logger LOG = LoggerFactory.getLogger(DiseaseController.class);
    @Autowired
    private DiseaseRepository diseaseRepository;

    public void createRandomDisease(Integer personId, int num, List<VirusEntity> viruses) {
        LOG.debug("Creating {} random disease for person with id={}", num, personId);
        if (num < 1) {
            return;
        }
        if (viruses.isEmpty()) {
            throw new VirusesNotFoundException();
        }
        List<DiseaseEntity> diseaseEntities = new ArrayList<>(num);
        DiseaseEntity.DiseaseStage[] stages = DiseaseEntity.DiseaseStage.values();
        LocalDate today = LocalDate.now();
        while (num-- > 0) {
            DiseaseEntity newEntity = new DiseaseEntity();
            newEntity.setPersonId(personId);
            int stageNum = (int) (Math.random() * 3); // выбираем одну из трех первых стадий случайно
            newEntity.setStage(stages[stageNum]);
            // дата указывается в зависимости от стадии
            newEntity.setDateOfInfection(today.minusDays(stageNum));
            newEntity.setVirusId(viruses.get((int) (Math.random() * viruses.size())).getId());
            diseaseEntities.add(newEntity);
        }
        diseaseRepository.saveAll(diseaseEntities);
    }
}
