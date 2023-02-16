package com.pedroza.prazo.calculoprazo.services;

import java.time.LocalDate;

public abstract class PrazoService {
	
	// método que vai ler os feriados de um arquivo TXT para montar o conjunto (Set) de cada região
	public abstract void loadHolidays();
	
	// este é o método central do programa:
	// calcula a quantidade de prazo desconsiderando dias úteis e feriados 
	public abstract LocalDate addBusinessDays(LocalDate startDate, int daysToAdd);

}
