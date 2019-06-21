package com.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;
import com.domain.DTO.UsuarioCadastradoDTO;
import com.domain.DTO.usuarioC_completo;
import com.service.AdministradoresServices;
import com.service.UsuarioCadastradoServices;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRest {

	@Autowired
	private UsuarioCadastradoServices service;

	
	  //Buscar Evento
	  
	  @RequestMapping(value = "/buscar/{id}",method = RequestMethod.GET) 
	  public ResponseEntity<?> buscar(@PathVariable String id) throws ObjectNotFoundException{
	  
	  UsuarioCadastrado evt = service.buscarUsuario(id); 
	  usuarioC_completo completo = new usuarioC_completo(evt);
	  return ResponseEntity.ok().body(completo);
	  
	  }
	  
	/*
	 * //Add evento
	 * 
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<?>
	 * adiconarEvento(@RequestBody Evento evt) { evt = service.adicionarEvento(evt);
	 * URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
	 * path("/{id}").buildAndExpand(evt.getId()).toUri(); return
	 * ResponseEntity.created(uri).build(); }
	 * 
	 * //editar evento
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<?> atualizarEvento(@PathVariable Integer id, @RequestBody
	 * Evento evt){ evt.setId(id); evt = service.atualizarEvento(evt);
	 * 
	 * return ResponseEntity.noContent().build(); }
	 */

	/*
	 * @RequestMapping(value = "/listar-todos", method = RequestMethod.GET) public
	 * ResponseEntity<?> BuscarTodos() { List<Evento> list = service.buscarTodos();
	 * List<Evento> list2 = new ArrayList();
	 * 
	 * for (Evento e : list) { if (e.isLiberado() == false) list2.add(e); }
	 * 
	 * return ResponseEntity.ok().body(list2); }
	 * 
	 * @RequestMapping(value = "/listar-todos/{id}", method = RequestMethod.GET)
	 * public ResponseEntity<?> liberar(@PathVariable Integer id) { List<Evento>
	 * list = service.buscarTodos();
	 * 
	 * Evento aux = new Evento();
	 * 
	 * for (Evento e : list) { if (e.getId() == id) { e.setLiberado(true); aux =
	 * service.atualizarEvento(e); } }
	 * 
	 * return ResponseEntity.ok().body(aux); }
	 */
}
