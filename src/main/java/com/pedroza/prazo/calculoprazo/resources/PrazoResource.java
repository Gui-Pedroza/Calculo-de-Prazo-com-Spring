package com.pedroza.prazo.calculoprazo.resources;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pedroza.prazo.calculoprazo.services.PrazoPPService;
import com.pedroza.prazo.calculoprazo.services.PrazoRPService;
import com.pedroza.prazo.calculoprazo.services.PrazoService;

@Controller
@RequestMapping("/")
public class PrazoResource {

	@Autowired
	PrazoRPService serviceRP;

	@Autowired
	PrazoPPService servicePP;
	
	/*@GetMapping("/calculate")
	@ResponseBody
    public String index() {
        return "template.html";
    }*/
	
	@GetMapping("/calculate")
	public ModelAndView showForm() {
	    ModelAndView modelAndView = new ModelAndView("template");
	    return modelAndView;
	}


	@PostMapping("/{city}")
	public ResponseEntity<LocalDate> calculate(@RequestParam("startDate") LocalDate startDate,
			@RequestParam("daysToAdd") int daysToAdd, @PathVariable("city") String city) {
		PrazoService service;
		switch (city) {
		case "calculateribeirao-preto":
			service = serviceRP;
			// carrega o conjunto de feriados para a região de Ribeirão Preto assim como nos
			// demais "case" abaixo
			serviceRP.loadHolidays();
			break;
		case "calculatepresidente-prudente":
			service = servicePP;
			servicePP.loadHolidays();
			break;
		// adicionar mais casos para outras cidades
		default:
			throw new IllegalArgumentException("Cidade não encontrada ou ainda não implantada: " + city);
		}
		LocalDate newDate = service.addBusinessDays(startDate, daysToAdd);
		return new ResponseEntity<LocalDate>(newDate, HttpStatus.OK);
	}

}
