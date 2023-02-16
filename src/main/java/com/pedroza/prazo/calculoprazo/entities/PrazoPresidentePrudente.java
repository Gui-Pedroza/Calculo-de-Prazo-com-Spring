package com.pedroza.prazo.calculoprazo.entities;

import org.springframework.stereotype.Component;

@Component
public class PrazoPresidentePrudente extends Prazo {
	
	private final String caminhoArquivo = 
			"C:\\Users\\gui_p\\Desktop\\Jornada\\Java\\Udemy\\Projetos_Spring_Tools\\calculoprazo\\PrazoTXT\\PrazoPresidentePrudente.txt";

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
