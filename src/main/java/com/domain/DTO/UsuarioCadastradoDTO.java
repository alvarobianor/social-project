package com.domain.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;


public class UsuarioCadastradoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String nome;
	private List<EventoDTO> meusEventos = new ArrayList<>();
	private List<EventoDTO> listaInteresse = new ArrayList<>();
	private List<EventoDTO> listaconfirmada = new ArrayList<>();
	
	public UsuarioCadastradoDTO() {
		super();
	}
	

	public UsuarioCadastradoDTO(UsuarioCadastrado usuario) {
		super();
		this.username = usuario.getUsername();
		this.nome = usuario.getNome();
		//this.meusEventos =usuario.getMeusEventos();
		//this.setListaInteresse(usuario.getMinhaListaInteresse());
		//this.setListaconfirmada(usuario.getMinhaListaConfirmada());
		
	}



	public List<EventoDTO> getMeusEventos() {
		return meusEventos;
	}


	public void setMeusEventos(List<EventoDTO> meusEventos) {
		this.meusEventos = meusEventos;
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


	public List<EventoDTO> getListaInteresse() {
		return listaInteresse;
	}


	public void setListaInteresse(List<EventoDTO> listaInteresse) {
		this.listaInteresse = listaInteresse;
	}


	public List<EventoDTO> getListaconfirmada() {
		return listaconfirmada;
	}


	public void setListaconfirmada(List<EventoDTO> listaconfirmada) {
		this.listaconfirmada = listaconfirmada;
	}
	
	
	
	
}
