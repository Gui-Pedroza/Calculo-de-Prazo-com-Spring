package com.pedroza.prazo.calculoprazo.entities;

import org.springframework.stereotype.Component;

@Component
public class PrazoPP extends Prazo {
	
	private final String caminhoArquivo = 
			"C:\\Users\\gui_p\\Desktop\\Jornada\\Java\\Udemy\\Projetos_Spring_Tools\\calculoprazo\\Prazos_TXT\\PrazoPP.txt";

	public PrazoPP() {
		super();		
	}	

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}	
	
	

}
