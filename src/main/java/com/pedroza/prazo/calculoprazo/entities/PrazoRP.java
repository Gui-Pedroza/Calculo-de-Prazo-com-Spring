package com.pedroza.prazo.calculoprazo.entities;

import org.springframework.stereotype.Component;

@Component
public class PrazoRP extends Prazo {
	
	private final String caminhoArquivo = 
			"D:\\Jornada\\Java\\Udemy\\Projetos_Spring_Tools\\calculoprazo\\Prazos_TXT\\PrazoRP.txt";

	public PrazoRP() {
		super();		
	}	

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}	
	
	

}
