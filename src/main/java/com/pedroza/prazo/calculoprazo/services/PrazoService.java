package com.pedroza.prazo.calculoprazo.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public abstract class PrazoService {
		
	@Autowired
	private static ApplicationContext applicationContext;
	
	public abstract void loadHolidays();
	
	
	public abstract LocalDate addBusinessDays(LocalDate startDate, int daysToAdd);
	
	public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }
	
	
	public static PrazoService selecionaCidade(String city) {
		switch (city) {
        case "calculateribeirao-preto":
        	return applicationContext.getBean(PrazoRPService.class);
        case "calculatepresidente-prudente":
        	return applicationContext.getBean(PrazoPPService.class);
        case "calculatecampinas":
            // criar classe Campinas

        case "calculatemarilia":
            // criar classe Marília

        default:
            throw new IllegalArgumentException("Cidade inválida: " + city);
		}
	}

}
