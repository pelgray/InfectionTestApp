package com.pelgray.InfectionTestApp.exceptions;

public class VirusesNotFoundException extends RuntimeException {
    public VirusesNotFoundException() {
        super("Could not find any viruses");
    }
}
