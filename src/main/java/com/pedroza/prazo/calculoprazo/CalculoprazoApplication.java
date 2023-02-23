package com.pedroza.prazo.calculoprazo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.pedroza.prazo.calculoprazo.services.PrazoService;

@SpringBootApplication
public class CalculoprazoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CalculoprazoApplication.class, args);
        
        PrazoService.setApplicationContext(context);
	}

}
