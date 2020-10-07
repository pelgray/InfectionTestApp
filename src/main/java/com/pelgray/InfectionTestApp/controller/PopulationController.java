package com.pelgray.InfectionTestApp.controller;

import com.pelgray.InfectionTestApp.domain.PopulationEntity;
import com.pelgray.InfectionTestApp.domain.VirusEntity;
import com.pelgray.InfectionTestApp.repository.PopulationRepository;
import com.pelgray.InfectionTestApp.repository.VirusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@CrossOrigin
@RestController
public class PopulationController {
    private static final Logger LOG = LoggerFactory.getLogger(PopulationController.class);
    @Autowired
    private PopulationRepository populationRepository;
    @Autowired
    private VirusRepository virusRepository;
    @Autowired
    private DiseaseController diseaseController;

    @DeleteMapping("/api/population/delete")
    public void deletePopulation() {
        LOG.debug("Removing information about the population");
        populationRepository.deleteAll();
    }

    /**
     * Запрос на создание популяции
     * @param num количество человек, которое необходимо сгенерировать
     * @param withDiseases при {@code true} будут созданы также до 4 случайных болезней. {@code true} по умолчанию
     */
    @PostMapping("/api/population/create")
    public void createRandomPerson(@RequestParam int num,
                                   @RequestParam(required = false, defaultValue = "true") boolean withDiseases) {
        LOG.debug("Creating {} random people", num);
        List<PopulationEntity> randomPerson = new ArrayList<>(num);
        while (num-- > 0) {
            randomPerson.add(new PopulationEntity());
        }
        Iterable<PopulationEntity> populationEntities = populationRepository.saveAll(randomPerson);

        List<VirusEntity> viruses = StreamSupport.stream(virusRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        if (withDiseases) {
            populationEntities.forEach(p -> diseaseController
                    .createRandomDisease(p.getPersonCode(), (int) (Math.random() * 5), viruses));
        }
    }
}
