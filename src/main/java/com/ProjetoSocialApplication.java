package com;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dao.EventosDAO;
import com.domain.Evento;

@SpringBootApplication
public class ProjetoSocialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSocialApplication.class, args);
	}

	@Autowired
	EventosDAO eventosDAO;

	@Override
	public void run(String... args) throws Exception {
		Evento evt = new Evento(null, "Corrida", "esporte", "rua cel joão",
			"Choró", "CE", "R$40", "muito bom", "+18", "R$400", null, null, null);
		
		eventosDAO.saveAll(Arrays.asList(evt));
	}
}
