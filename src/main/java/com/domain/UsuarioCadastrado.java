package com.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.debug.Event;

@Entity
public class UsuarioCadastrado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String username;
	private String senha;

	private String nome;
	private String cpf_cnpj;
	private String email;
	private Integer idade;

	@JsonIgnore
	@OneToMany(mappedBy = "dono")
	private List<Evento> meusEventos = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "listaInteresse")
	private List<Evento> minhaListaInteresse = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "listaConfirmada")
	private List<Evento> minhaListaConfirmada = new ArrayList<>();

	public UsuarioCadastrado() {}

	public UsuarioCadastrado(String username, String senha, String nome, String cpf_cnpj, String email, Integer idade) {
		super();
		this.username = username;
		this.senha = senha;
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.email = email;
		this.idade = idade;
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

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public List<Evento> getMeusEventos() {
		return meusEventos;
	}

	public void setMeusEventos(List<Evento> meusEventos) {
		this.meusEventos = meusEventos;
	}
	

	public List<Evento> getMinhaListaInteresse() {
		return minhaListaInteresse;
	}

	public void setMinhaListaInteresse(List<Evento> minhaListaInteresse) {
		this.minhaListaInteresse = minhaListaInteresse;
	}

	public List<Evento> getMinhaListaConfirmada() {
		return minhaListaConfirmada;
	}

	public void setMinhaListaConfirmada(List<Evento> minhaListaConfirmada) {
		this.minhaListaConfirmada = minhaListaConfirmada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioCadastrado other = (UsuarioCadastrado) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
