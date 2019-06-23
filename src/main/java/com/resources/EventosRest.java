package com.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;
import com.domain.DTO.EventoRespostaDTO;
import com.domain.DTO.UsuarioCadastradoDTO;
import com.domain.DTO.UsuarioDTO_username_nome;
import com.service.EventosServices;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/eventos")
public class EventosRest {
	
	@Autowired
	private EventosServices service;
	
	//find Event
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) throws ObjectNotFoundException{
		
		Evento evt = service.buscarEventos(id);
		EventoRespostaDTO evtDto = new EventoRespostaDTO(evt);
		
		List<UsuarioDTO_username_nome> listInteresse = evt.getListaInteresse().stream().map(obj -> new UsuarioDTO_username_nome(obj)).collect(Collectors.toList());		
		List<UsuarioDTO_username_nome> listConfirmada = evt.getListaConfirmada().stream().map(obj -> new UsuarioDTO_username_nome(obj)).collect(Collectors.toList());		
		
		evtDto.setListConfirmado(listConfirmada);
		evtDto.setListInteresse(listInteresse);
		
		
		return ResponseEntity.ok().body(evtDto);
		
	}
	
	//Add event
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> adiconarEvento(@RequestBody Evento evt) {
		evt = service.adicionarEvento(evt);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(evt.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// event
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizarEvento(@PathVariable Integer id, @RequestBody Evento evt){
		evt.setId(id);
		evt = service.atualizarEvento(evt);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "interesse/{idE}/{idU}", method = RequestMethod.PUT)
	public ResponseEntity<?> setarInteresse(@PathVariable Integer idE, @PathVariable String idU){
		
		//instancia evento e ususario  DTO
		
		UsuarioCadastrado usu = service.buscarUsuario(idU);
		Evento evt = service.buscarEventos(idE);
		
		//salva num auxiliar as listas para depois serem setadas
		
		List<UsuarioCadastrado> auxUsuario = evt.getListaInteresse();
		List<Evento> auxEvento = usu.getMinhaListaInteresse();
		
		//Agr sim salva as listas aualizadas com DTO
		
		auxUsuario.add(usu);
		evt.setListaInteresse(auxUsuario);
		auxEvento.add(evt);
		evt.setListaInteresse(auxUsuario);
		
		//atualiza as instacias no banco de dados
		
		evt = service.atualizarEvento(evt);
		usu = service.atualizarUsuario(usu);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "interesse-excluir/{idE}/{idU}", method = RequestMethod.PUT)
	public ResponseEntity<?> exluirInteresse(@PathVariable Integer idE, @PathVariable String idU){
		
		UsuarioCadastrado usu = service.buscarUsuario(idU);
		Evento evt = service.buscarEventos(idE);
		
		List<UsuarioCadastrado> auxUsuario = evt.getListaInteresse();
		List<Evento> auxEvento = usu.getMinhaListaInteresse();
		
		auxUsuario.remove(usu);
		auxEvento.remove(evt);
		evt.setListaInteresse(auxUsuario);
		evt.setListaInteresse(auxUsuario);
		
		evt = service.atualizarEvento(evt);
		usu = service.atualizarUsuario(usu);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/buscar-todos", method = RequestMethod.GET)
	  public ResponseEntity<?> buscarPage(
			  @RequestParam(name = "page", defaultValue = "0") Integer page,
			  @RequestParam(name = "linesPP", defaultValue = "2") Integer linesPP,
			  @RequestParam(name = "ordem", defaultValue = "nome") String orderBy,
			  @RequestParam(name = "direction", defaultValue = "ASC") String direction){
		
		Page<Evento> pagina = service.buscarPage(page, linesPP, direction, orderBy);
		
		return ResponseEntity.ok().body(pagina);
	} 
	
}
