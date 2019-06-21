package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exceptions.ObjectNotFoundException;

import com.dao.EventosDAO;
import com.dao.UsuarioCadastradoDAO;
import com.domain.Evento;
import com.domain.UsuarioCadastrado;

@Service
public class EventosServices {

	@Autowired
	private EventosDAO DAO;
	
	@Autowired
	private UsuarioCadastradoDAO usuDAO;
	
	public Evento buscarEventos(Integer id) throws ObjectNotFoundException {
		Optional<Evento> evento = DAO.findById(id);
		
		return evento.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Evento adicionarEvento(Evento evt) {
		return evt = DAO.save(evt);
	}

	public Evento atualizarEvento(Evento evt) {
		// TODO Auto-generated method stub
		return evt = DAO.save(evt);
	}
	
	public UsuarioCadastrado buscarUsuario(String id) throws ObjectNotFoundException{
		Optional<UsuarioCadastrado> usuario = usuDAO.findById(id);
		
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public UsuarioCadastrado atualizarUsuario(UsuarioCadastrado usu) {
		// TODO Auto-generated method stub
		return usu = usuDAO.save(usu);
	}
}
