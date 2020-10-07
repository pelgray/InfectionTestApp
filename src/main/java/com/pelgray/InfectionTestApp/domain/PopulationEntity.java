package com.pelgray.InfectionTestApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "population")
public class PopulationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personCode;
    @Column(name = "date_of_death")
    private LocalDate dateOfDeath;

    public Integer getPersonCode() {
        return personCode;
    }

    public void setPersonCode(Integer personCode) {
        this.personCode = personCode;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public String toString() {
        return "Population{" +
                "personCode=" + personCode +
                ", dateOfDeath=" + dateOfDeath +
                '}';
    }
}
