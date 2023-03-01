package com.pedroza.prazo.calculoprazo.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public class Prazo {
	
	private String caminhoArquivo;
	
	Set<LocalDate> holidays = new HashSet<>();	
	

	public Optional<Set<LocalDate>> getHolidays() {
		return Optional.of(holidays);
	}

	public void setHolidays(Set<LocalDate> holidays) {
		this.holidays = holidays;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public Prazo() {
	}

	public Prazo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

}
