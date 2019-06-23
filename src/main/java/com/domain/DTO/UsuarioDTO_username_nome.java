package com.domain.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;


public class UsuarioDTO_username_nome implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String nome;

	/*
	 * private List<EventoDTO> meusEventos = new ArrayList<>(); private
	 * List<EventoDTO> listaInteresse = new ArrayList<>(); private List<EventoDTO>
	 * listaconfirmada = new ArrayList<>();
	 */
	public UsuarioDTO_username_nome() {
		super();
	}
	

	public UsuarioDTO_username_nome(UsuarioCadastrado usuario) {
		super();
		this.username = usuario.getUsername();
		this.nome = usuario.getNome();
		//this.meusEventos =usuario.getMeusEventos();
		//this.setListaInteresse(usuario.getMinhaListaInteresse());
		//this.setListaconfirmada(usuario.getMinhaListaConfirmada());
		
	}





	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
}
