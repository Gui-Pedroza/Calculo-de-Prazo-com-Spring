package com.pedroza.prazo.calculoprazo.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pedroza.prazo.calculoprazo.services.PrazoPPService;
import com.pedroza.prazo.calculoprazo.services.PrazoRPService;
import com.pedroza.prazo.calculoprazo.services.PrazoService;

@Controller
public class PrazoResource {

	@Autowired
	PrazoRPService serviceRP;

	@Autowired
	PrazoPPService servicePP;
	
		
	@PostMapping("/{city}")
	public ResponseEntity<LocalDate> calculate(@RequestParam("startDate") LocalDate startDate,
			@RequestParam("daysToAdd") int daysToAdd, @PathVariable("city") String city) {
		PrazoService service = PrazoService.selecionaCidade(city);	
		service.loadHolidays();
		LocalDate newDate = service.addBusinessDays(startDate, daysToAdd);
		return new ResponseEntity<LocalDate>(newDate, HttpStatus.OK);
	}

}
