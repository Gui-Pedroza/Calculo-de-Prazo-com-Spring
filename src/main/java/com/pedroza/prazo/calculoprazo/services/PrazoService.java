package com.pedroza.prazo.calculoprazo.services;

import java.time.LocalDate;

public abstract class PrazoService {
	
	
	public abstract void loadHolidays();
	
	
	public abstract LocalDate addBusinessDays(LocalDate startDate, int daysToAdd);
	
	// tirar o metodo de selecionar cidade da API e trazer ele pra service:
	public static PrazoService selecionaCidade(String city) {
		PrazoService service = null;
		switch (city) {
		case "ribeirao-preto":
			service = new PrazoRPService();
		break;
		case "presidente-prudente":
			service = new PrazoPPService();
		break;
		case "campinas":
			// criar classe Campinas
		break;
		case "marilia":
			// criar classe Marília
		default:
			throw new IllegalArgumentException("Cidade inválida: " + city);		
		}
		return service;
	}

}
