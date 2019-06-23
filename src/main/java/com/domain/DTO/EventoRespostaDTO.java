package com.domain.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;

public class EventoRespostaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	private UsuarioCadastrado dono;

	private List<UsuarioDTO_username_nome> listInteresse = new ArrayList<>();
	private List<UsuarioDTO_username_nome> listConfirmado = new ArrayList<>();

	public EventoRespostaDTO() {
	}

	public EventoRespostaDTO(Evento e) {
		super();
		this.id = e.getId();
		this.nome = e.getNome();
		this.dono = e.getDono();
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

	public UsuarioCadastrado getDono() {
		return dono;
	}

	public void setDono(UsuarioCadastrado dono) {
		this.dono = dono;
	}

	public List<UsuarioDTO_username_nome> getListInteresse() {
		return listInteresse;
	}

	public void setListInteresse(List<UsuarioDTO_username_nome> listInteresse) {
		this.listInteresse = listInteresse;
	}

	public List<UsuarioDTO_username_nome> getListConfirmado() {
		return listConfirmado;
	}

	public void setListConfirmado(List<UsuarioDTO_username_nome> listConfirmado) {
		this.listConfirmado = listConfirmado;
	}

	
}
