package com.domain.DTO;

import java.io.Serializable;

import javax.persistence.Id;

import com.domain.UsuarioCadastrado;


public class UsuarioCadastradoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String nome;
	
	public UsuarioCadastradoDTO() {
		super();
	}
	

	public UsuarioCadastradoDTO(UsuarioCadastrado usuario) {
		super();
		this.username = usuario.getUsername();
		this.nome = usuario.getNome();
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
