package com.resources;

import java.net.URI;
import java.util.List;
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

import com.domain.UsuarioCadastrado;
import com.domain.DTO.EventoDTO;
import com.domain.DTO.UsuarioCadastradoDTO;
import com.service.UsuarioCadastradoServices;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRest {

	@Autowired
	private UsuarioCadastradoServices service;

	
	  //Buscar Evento formatado com DTO
	  
	  @RequestMapping(value = "/buscar/{id}",method = RequestMethod.GET) 
	  public ResponseEntity<?> buscar(@PathVariable String id) throws ObjectNotFoundException{
	  
	  UsuarioCadastrado usuario = service.buscarUsuario(id); 
	  UsuarioCadastradoDTO usuDto = new UsuarioCadastradoDTO(usuario);
	  List<EventoDTO> minhaLisEventoDto = usuario.getMeusEventos().stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
	  List<EventoDTO> interesseLisEventoDto = usuario.getMinhaListaInteresse().stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
	  List<EventoDTO> confirmadoLisEventoDto = usuario.getMinhaListaConfirmada().stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
	  //usuarioC_completo completo = new usuarioC_completo(evt);
	  usuDto.setMeusEventos(minhaLisEventoDto);
	  usuDto.setListaInteresse(interesseLisEventoDto);
	  usuDto.setListaconfirmada(confirmadoLisEventoDto);
	  return ResponseEntity.ok().body(usuDto);
	  
	  }
	  
	  @RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<?> adiconarEvento(@RequestBody UsuarioCadastrado usuario) {
			usuario = service.adicionarEvento(usuario);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
					path("/{id}").buildAndExpand(usuario.getUsername()).toUri();
			return ResponseEntity.created(uri).build();
	  }
	  
	  @RequestMapping(value = "/buscar/{id}/editar", method = RequestMethod.PUT)
	  public ResponseEntity<?> editar(@PathVariable String id, @RequestBody UsuarioCadastrado usu){//se mudar o username não funciona
		  UsuarioCadastrado usuario = service.buscarUsuario(id);
		  service.atualizaSemPerder(usuario, usu);
		  usuario = service.atualizar(usuario);
		  
		  return ResponseEntity.noContent().build();
	  }
	  
	  @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<?> delete(@PathVariable String id) throws Exception {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
	  
	  //método auxiliar que seria passado no lugar no metodo anonimo
	  public UsuarioCadastradoDTO auxUsuarioDTO(UsuarioCadastrado usuario) {
		  UsuarioCadastradoDTO aux = new UsuarioCadastradoDTO(usuario);
		  List<EventoDTO> minhaLisEventoDto = usuario.getMeusEventos().stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
		  List<EventoDTO> interesseLisEventoDto = usuario.getMinhaListaInteresse().stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
		  List<EventoDTO> confirmadoLisEventoDto = usuario.getMinhaListaConfirmada().stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
		  aux.setMeusEventos(minhaLisEventoDto);
		  aux.setListaInteresse(interesseLisEventoDto);
		  aux.setListaconfirmada(confirmadoLisEventoDto);
		  return aux;
	  }
	  
	  @RequestMapping(value = "/buscar-todos", method = RequestMethod.GET)
	  public ResponseEntity<?> buscarPage(
			  @RequestParam(name = "page", defaultValue = "0") Integer page,
			  @RequestParam(name = "linesPP", defaultValue = "2") Integer linesPP,
			  @RequestParam(name = "ordem", defaultValue = "nome") String orderBy,
			  @RequestParam(name = "direction", defaultValue = "ASC") String direction){
		  Page<UsuarioCadastrado> pagina = service.buscarPages(page, linesPP, direction, orderBy);
		  Page<UsuarioCadastradoDTO> objDTO = pagina.map(obj -> auxUsuarioDTO(obj));
		  return ResponseEntity.ok().body(objDTO);
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
