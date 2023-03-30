package com.pedroza.prazo.calculoprazo.services;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public abstract class PrazoService {
		
	
	private static ApplicationContext applicationContext;
	
	
	public abstract void loadHolidays();
	
	
	public abstract LocalDate addBusinessDays(LocalDate startDate, int daysToAdd);
	
	
	public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }
		
	public static PrazoService selecionaCidade(String city) {
		switch (city) {
        case "ribeirao-preto":
        	return applicationContext.getBean(PrazoRPService.class);
        case "presidente-prudente":
        	return applicationContext.getBean(PrazoPPService.class);
        case "campinas":
            // criar classe Campinas

        case "marilia":
            // criar classe Marília

        default:
            throw new IllegalArgumentException("Cidade inválida ou não implementada: " + city);
		}
	}

}
