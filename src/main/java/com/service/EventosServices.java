package com.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dao.EventosDAO;
import com.dao.UsuarioCadastradoDAO;
import com.domain.Evento;
import com.domain.UsuarioCadastrado;
import com.domain.DTO.EventoDTOpost_put;
import com.exceptions.ObjectNotFoundException;


@Service
public class EventosServices {

	@Autowired
	private EventosDAO DAO;

	@Autowired
	private UsuarioCadastradoDAO usuDAO;
	
	public EventosServices() {}

	public Evento buscarEventos(Integer id) throws ObjectNotFoundException {
		Optional<Evento> evento = DAO.findById(id);

		return evento.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public Evento adicionarEvento(Evento evt) {
		return evt = DAO.save(evt);
	}

	public Evento atualizarEvento(Evento evt) {
		// TODO Auto-generated method stub
		return evt = DAO.save(evt);
	}

	public UsuarioCadastrado buscarUsuario(String id) throws ObjectNotFoundException {
		Optional<UsuarioCadastrado> usuario = usuDAO.findById(id);

		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public UsuarioCadastrado atualizarUsuario(UsuarioCadastrado usu) {
		// TODO Auto-generated method stub
		return usu = usuDAO.save(usu);
	}

	public Page<Evento> buscarPage(Integer page, Integer linesPP, String direction, String orderBy) {
		
		PageRequest evt = PageRequest.of(page, linesPP, Direction.valueOf(direction), orderBy);
		
		return DAO.findAll(evt);
	}

	public void delete(Integer id) throws Exception {
		buscarEventos(id);
		
		try {
			DAO.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Não é possível excluir objetos relacionados");
		}
	}

	//tem que criar um método para iniciar as colecoes separados dependendo se já existir ou não
		public Evento fromDTO(EventoDTOpost_put e) {
			Evento evento = new Evento(e.getId(), e.getNome(),
					e.getTipo(), e.getEndereco(), e.getCidade(), e.getEstado(), e.getValores_tipo(),
					e.getDescricao(), e.getFaixaEtaria(), e.getValor(), 
					e.getData(), e.getHora(), null);
			evento.setLiberado(e.isLiberado());
			evento.setDono(buscarUsuario(e.getDono()));
			evento.setListaInteresse(new ArrayList<>());
			evento.setListaConfirmada(new ArrayList<>());
			return evento;
		}
		
}
