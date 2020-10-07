package com.pelgray.InfectionTestApp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "viruses")
public class VirusEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private VirusType type;
    private Double transmission;
    @Column(name = "life_exp_after_infection")
    private Short lifeExpAfterInfection;
    private Short mortality;
    @Column(name = "re_infection")
    private Short reInfection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VirusType getType() {
        return type;
    }

    public void setType(VirusType type) {
        this.type = type;
    }

    public Double getTransmission() {
        return transmission;
    }

    public void setTransmission(Double transmission) {
        this.transmission = transmission;
    }

    public Short getLifeExpAfterInfection() {
        return lifeExpAfterInfection;
    }

    public void setLifeExpAfterInfection(Short lifeExpAfterInfection) {
        this.lifeExpAfterInfection = lifeExpAfterInfection;
    }

    public Short getMortality() {
        return mortality;
    }

    public void setMortality(Short mortality) {
        this.mortality = mortality;
    }

    public Short getReInfection() {
        return reInfection;
    }

    public void setReInfection(Short reInfection) {
        this.reInfection = reInfection;
    }

    @Override
    public String toString() {
        return "Virus{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", transmission=" + transmission +
                ", lifeExpAfterInfection=" + lifeExpAfterInfection +
                ", mortality=" + mortality +
                ", reInfection=" + reInfection +
                '}';
    }

    public enum VirusType {
        RNA,
        DNA,
        RETROVIRUS
    }
}
