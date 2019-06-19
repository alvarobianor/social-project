package com.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Evento;
import com.service.EventosServices;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/eventos")
public class EventosRest {
	
	@Autowired
	private EventosServices service;
	
	//Buscar Evento
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws ObjectNotFoundException{
		
		Evento evt = service.buscarEventos(id);
		return ResponseEntity.ok().body(evt);
		
	}
	
	//Add evento
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> adiconarEvento(@RequestBody Evento evt) {
		evt = service.adicionarEvento(evt);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(evt.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//editar evento
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizarEvento(@PathVariable Integer id, @RequestBody Evento evt){
		evt.setId(id);
		evt = service.atualizarEvento(evt);
		
		return ResponseEntity.noContent().build();
	}
}
