package com.pelgray.InfectionTestApp.controller.advice;

import com.pelgray.InfectionTestApp.exceptions.VirusNotFoundException;
import com.pelgray.InfectionTestApp.exceptions.VirusesNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class VirusNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler({VirusNotFoundException.class, VirusesNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String virusNotFoundHandler(RuntimeException ex) {
        return ex.getMessage();
    }
}
