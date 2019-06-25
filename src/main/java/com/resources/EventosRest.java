package com.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;
import com.domain.DTO.EventoDTOpost_put;
import com.domain.DTO.EventoRespostaDTO;
import com.domain.DTO.UsuarioDTO_username_nome;
import com.service.EventosServices;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/eventos")
public class EventosRest {

	@Autowired
	private EventosServices service;

	// find Event
	/*
	 * @RequestMapping(value = "/{id}",method = RequestMethod.GET) public
	 * ResponseEntity<?> buscar2(@PathVariable Integer id) throws
	 * ObjectNotFoundException{
	 * 
	 * Evento evt = service.buscarEventos(id); EventoRespostaDTO evtDto = new
	 * EventoRespostaDTO(evt);
	 * 
	 * List<UsuarioDTO_username_nome> listInteresse =
	 * evt.getListaInteresse().stream().map(obj -> new
	 * UsuarioDTO_username_nome(obj)).collect(Collectors.toList());
	 * List<UsuarioDTO_username_nome> listConfirmada =
	 * evt.getListaConfirmada().stream().map(obj -> new
	 * UsuarioDTO_username_nome(obj)).collect(Collectors.toList());
	 * 
	 * evtDto.setListConfirmado(listConfirmada);
	 * evtDto.setListInteresse(listInteresse);
	 * 
	 * 
	 * return ResponseEntity.ok().body(evtDto);
	 * 
	 * }
	 */

	@RequestMapping(value = "/{id}")
	public ModelAndView buscar(@PathVariable Integer id) throws ObjectNotFoundException {

		Evento evt = service.buscarEventos(id);

		ModelAndView mv = new ModelAndView("/docs/4.1/examples/carousel/evento1");
		mv.addObject("evento", evt);
		return mv;

	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable Integer id) throws Exception {
		service.delete(id);

		ModelAndView mv = new ModelAndView("redirect:/{id}");
		// mv.addObject("evento",evt);
		return mv;

	}

	@RequestMapping("/formulario")
	public ModelAndView retornarForm() {
		ModelAndView mv = new ModelAndView("/docs/4.1/examples/carousel/cadastrarEvento");

		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {

		List<Evento> pagina = service.buscarCarrocel();
		
		ModelAndView mv = new ModelAndView("/docs/4.1/examples/carousel/index");
		
		mv.addObject("evento0", pagina.get(0));
		mv.addObject("evento1", pagina.get(0));
		
		return mv;
	}

	// Add event
	@PostMapping()
	public ModelAndView adiconarEvento(@Validated EventoDTOpost_put evt, @RequestParam(value= "imagem") MultipartFile imagem) {
		Evento evento = service.fromDTO(evt);
		service.adicionarEvento(evento, imagem);
		
		ModelAndView mv = new ModelAndView("/docs/4.1/examples/carousel/index");
		// mv.addObject("evento",evt);
		return mv;
	}

	// update event
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> atualizarEvento(@PathVariable Integer id,  EventoDTOpost_put evtDto) {
		Evento evt = service.fromDTO(evtDto);
		evt.setId(id);
		evt = service.atualizarEvento(evt);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "interesse/{idE}/{idU}", method = RequestMethod.PUT)
	public ResponseEntity<?> setarInteresse(@PathVariable Integer idE, @PathVariable String idU) {

		// instancia evento e ususario DTO

		UsuarioCadastrado usu = service.buscarUsuario(idU);
		Evento evt = service.buscarEventos(idE);

		// salva num auxiliar as listas para depois serem setadas

		List<UsuarioCadastrado> auxUsuario = evt.getListaInteresse();
		List<Evento> auxEvento = usu.getMinhaListaInteresse();

		// Agr sim salva as listas aualizadas com DTO

		auxUsuario.add(usu);
		evt.setListaInteresse(auxUsuario);
		auxEvento.add(evt);
		evt.setListaInteresse(auxUsuario);

		// atualiza as instacias no banco de dados

		evt = service.atualizarEvento(evt);
		usu = service.atualizarUsuario(usu);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "interesse-excluir/{idE}/{idU}", method = RequestMethod.PUT)
	public ResponseEntity<?> exluirInteresse(@PathVariable Integer idE, @PathVariable String idU) {

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
	
	@GetMapping("/buscartodos")
	public ModelAndView buscarTodos() {

		List<Evento> pagina = service.buscarTodos();
		
		ModelAndView mv = new ModelAndView("/docs/4.1/examples/carousel/Eventos");
		
		mv.addObject("list", pagina);
		
		return mv;
	}

	/*
	 * @RequestMapping(value = "/buscar-todos", method = RequestMethod.GET) public
	 * ModelAndView buscarPage(@RequestParam(name = "page", defaultValue = "0")
	 * Integer page,
	 * 
	 * @RequestParam(name = "linesPP", defaultValue = "2") Integer linesPP,
	 * 
	 * @RequestParam(name = "ordem", defaultValue = "nome") String orderBy,
	 * 
	 * @RequestParam(name = "direction", defaultValue = "ASC") String direction) {
	 * 
	 * Page<Evento> pagina = service.buscarPage(page, linesPP, direction, orderBy);
	 * 
	 * ModelAndView mv = new ModelAndView("/docs/4.1/examples/carousel/Eventos");
	 * 
	 * mv.addObject("page", pagina);
	 * 
	 * return mv; }
	 */
}
