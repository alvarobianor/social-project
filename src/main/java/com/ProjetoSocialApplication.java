package com;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dao.EventosDAO;
import com.dao.UsuarioCadastradoDAO;
import com.domain.Evento;
import com.domain.UsuarioCadastrado;

@SpringBootApplication
public class ProjetoSocialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSocialApplication.class, args);
	}

	@Autowired
	EventosDAO eventosDAO;
	
	@Autowired
	UsuarioCadastradoDAO uDao;

	@Override
	public void run(String... args) throws Exception {
		Evento evt = new Evento(null, "Corrida", "esporte", "rua cel joão",
			"Choró", "CE", "R$40", "muito bom", "+18", "R$400", null, null, null);
		Evento evt2 = new Evento(null, "Passeata", "viço", "rua cel",
				"Quixadá", "CE", "R$90", "muito bom", "+18", "R$400", null, null, null);
		Evento evt3 = new Evento(null, "Matar bozominion", "Lazer", "Brasil todo",
				"Mundo", "CE", "R$0", "Maravilhoso", "Todas as idades", " te pagamos R$400", null, null, null);
		Evento evt4 = new Evento(null, "idhsijdfs", "werwerwe", "rua cel joão",
				"Choró", "CE", "R$40", "dsafadf", "+18", "R$4545", null, null, null);
		
		UsuarioCadastrado usu = new UsuarioCadastrado("stkabianor", "1234", "Álvaro", "05796070380", "bia", 20);
		
		UsuarioCadastrado usu2 = new UsuarioCadastrado("darkCarijo", "1234", "Bianor", "05796070380", "bia", 20);
		
		
		evt.setDono(usu);
		evt2.setDono(usu);
		evt3.setDono(usu2);
		evt4.setDono(usu);
		usu.setMeusEventos(Arrays.asList(evt, evt2, evt4));
		usu2.setMeusEventos(Arrays.asList(evt3));
		
		uDao.saveAll(Arrays.asList(usu, usu2));
		eventosDAO.saveAll(Arrays.asList(evt, evt2, evt3, evt4));
	}
}
