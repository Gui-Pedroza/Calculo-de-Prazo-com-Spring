package com.pedroza.prazo.calculoprazo.entities;

import org.springframework.stereotype.Component;

@Component
public class PrazoPresidentePrudente extends Prazo {
	
	private final String caminhoArquivo = 
			"D:\\Jornada\\Java\\Udemy\\Projetos_Spring_Tools\\calculoprazo\\Prazos_TXT\\PrazoPP.txt";
			

	public PrazoPresidentePrudente() {
		super();
		
	}

	public PrazoPresidentePrudente(String caminhoArquivo) {
		super(caminhoArquivo);
		
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

}
