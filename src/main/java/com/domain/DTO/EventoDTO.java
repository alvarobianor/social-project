package com.domain.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EventoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	

	/*
	 * private UsuarioCadastrado dono;
	 * 
	 * private List<UsuarioCadastrado> listInteresse = new ArrayList<>(); private
	 * List<UsuarioCadastrado> listConfirmado = new ArrayList<>();
	 */
	public EventoDTO() {
	}

	public EventoDTO(Evento e) {
		super();
		this.id = e.getId();
		this.nome = e.getNome();
		// this.dono = e.getDono();
		

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
