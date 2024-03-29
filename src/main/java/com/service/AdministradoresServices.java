package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EventosDAO;
import com.domain.Evento;
import com.exceptions.ObjectNotFoundException;

@Service
public class AdministradoresServices {

	@Autowired
	private EventosDAO DAO;
	
	
	/*
	 * public Evento buscarEventos(Integer id) throws ObjectNotFoundException {
	 * Optional<Evento> evento = DAO.findById(id);
	 * 
	 * return evento.orElseThrow(() -> new ObjectNotFoundException(
	 * "Objeto não encontrado! Id: " + id)); }
	 * 
	 * public Evento adicionarEvento(Evento evt) { return evt = DAO.save(evt); }
	 */
	  
	  public Evento atualizarEvento(Evento evt) { // TODO Auto-generated method
	  return evt = DAO.save(evt); }
	 
	
	public List<Evento> buscarTodos() {
		
		return DAO.findAll();
	}
}
