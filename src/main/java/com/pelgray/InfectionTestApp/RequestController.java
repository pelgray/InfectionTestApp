package com.pelgray.InfectionTestApp;

import com.pelgray.InfectionTestApp.domain.VirusEntity;
import com.pelgray.InfectionTestApp.repository.VirusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RequestController {
    private static final Logger LOG = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private VirusRepository virusRepository;

    @PostMapping("/api/viruses/add")
    public void addVirus(@RequestBody VirusEntity virus) {
        LOG.info("Adding a virus \"{}\"", virus.toString());
        virusRepository.save(virus);
    }

    @GetMapping("/api/viruses/get")
    public VirusEntity getVirus(@RequestParam String virusName) {
        LOG.info("Getting a virus by name \"{}\"", virusName);

        return virusRepository.findByName(virusName);
    }
}
