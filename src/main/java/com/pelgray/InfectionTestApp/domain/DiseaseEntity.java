package com.pelgray.InfectionTestApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "diseases")
public class DiseaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "virus_id")
    private Integer virusId;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "date_of_infection")
    private LocalDate dateOfInfection;
    private DiseaseStage stage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVirusId() {
        return virusId;
    }

    public void setVirusId(Integer virusId) {
        this.virusId = virusId;
    }

    public LocalDate getDateOfInfection() {
        return dateOfInfection;
    }

    public void setDateOfInfection(LocalDate dateOfInfection) {
        this.dateOfInfection = dateOfInfection;
    }

    public DiseaseStage getStage() {
        return stage;
    }

    public void setStage(DiseaseStage stage) {
        this.stage = stage;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", virusId=" + virusId +
                ", dateOfInfection=" + dateOfInfection +
                ", stage=" + stage +
                ", personId=" + personId +
                '}';
    }

    public enum DiseaseStage {
        ATTACHMENT,
        PENETRATION,
        UNCOATING,
        REPLICATION,
        ASSEMBLY,
        RELEASE
    }
}
