package com.domain.DTO;

import java.io.Serializable;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;

public class EventoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	//private UsuarioCadastrado dono;
	
	public EventoDTO() {}
	
	public EventoDTO(Evento e) {
		super();
		this.id = e.getId();
		this.nome = e.getNome();
		//this.dono = e.getDono();
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
