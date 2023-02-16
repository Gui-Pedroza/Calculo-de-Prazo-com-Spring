package com.pedroza.prazo.calculoprazo.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedroza.prazo.calculoprazo.services.PrazoPPService;
import com.pedroza.prazo.calculoprazo.services.PrazoRPService;
import com.pedroza.prazo.calculoprazo.services.PrazoService;

@RestController
@RequestMapping("/calculate")
public class PrazoResource {

	@Autowired
	PrazoRPService serviceRP;

	@Autowired
	PrazoPPService servicePP;

	@PostMapping("/{city}")
	public ResponseEntity<LocalDate> calculate(
			@RequestParam("startDate") LocalDate startDate,
			@RequestParam("daysToAdd") int daysToAdd, 
			@PathVariable("city") String city) {		
		PrazoService service;
		switch (city) {
        case "ribeirao-preto":
            service = serviceRP;
            
            // carrega o conjunto de feriados para a região de Ribeirão Preto assim como nos demais "case" abaixo
            serviceRP.loadHolidays();
            break;
        case "presidente-prudente":
            service = servicePP;
            servicePP.loadHolidays();
            break;
        // adicionar mais casos para outras cidades
        default:
            throw new IllegalArgumentException("Cidade inválida: " + city);
    }
		LocalDate newDate = service.addBusinessDays(startDate, daysToAdd);
		return new ResponseEntity<LocalDate>(newDate, HttpStatus.OK);
	}

}
