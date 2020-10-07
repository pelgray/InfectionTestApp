package com.pelgray.InfectionTestApp.exceptions;

public class VirusNotFoundException extends RuntimeException {
    public VirusNotFoundException(String virusName) {
        super(String.format("Could not find virus with name \"%s\"", virusName));
    }
}
