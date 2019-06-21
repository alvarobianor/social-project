package com.domain.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class usuarioC_completo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String username;
	private String senha;

	private String nome;
	private String cpf_cnpj;
	private String email;
	private Integer idade;

	
	private List<Evento> meusEventos = new ArrayList();

	
	private List<Evento> minhaListaInteresse = new ArrayList();

	
	private List<Evento> minhaListaConfirmada = new ArrayList();

	public usuarioC_completo() {}

	public usuarioC_completo(UsuarioCadastrado aux) {
		this.username = aux.getUsername();
		this.senha = "1234";
		this.nome = aux.getNome();
		this.cpf_cnpj = aux.getCpf_cnpj();
		this.email = aux.getEmail();
		this.idade = aux.getIdade();
		this.meusEventos = aux.getMeusEventos();
		this.minhaListaInteresse = aux.getMinhaListaInteresse();
		this.minhaListaConfirmada = aux.getMinhaListaConfirmada();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		usuarioC_completo other = (usuarioC_completo) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

}