package com.pedroza.prazo.calculoprazo.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedroza.prazo.calculoprazo.services.PrazoPPService;
import com.pedroza.prazo.calculoprazo.services.PrazoRPService;

@RestController
@RequestMapping
public class PrazoResource {
	
	@Autowired
	PrazoRPService serviceRP;
	
	@Autowired
	PrazoPPService servicePP;	

		
	@PostMapping("/calculate/RP")
	public ResponseEntity<LocalDate> calculate(@RequestParam("startDate") LocalDate startDate, @RequestParam("daysToAdd") int daysToAdd) {
	  LocalDate newDate = serviceRP.addBusinessDays(startDate, daysToAdd);
	  return new ResponseEntity<LocalDate>(newDate, HttpStatus.OK);
	}
	
	/*@PostMapping("/calculate/PP")
	public ResponseEntity<LocalDate> calculate(@RequestParam("startDate") LocalDate startDate, @RequestParam("daysToAdd") int daysToAdd) {
		LocalDate newDate = servicePP.addBusinessDays(startDate, daysToAdd);
		return new ResponseEntity<LocalDate>(newDate, HttpStatus.OK);
	}*/
	
	


}
