package com.domain.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import com.domain.Evento;
import com.domain.UsuarioCadastrado;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.service.UsuarioCadastradoServices;

public class EventoDTOpost_put implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	private Integer id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String tipo;
	@NotEmpty
	private String endereco;
	@NotEmpty
	private String cidade;
	@NotEmpty
	private String estado;
	@NotEmpty
	private String valores_tipo;
	@NotEmpty
	private String descricao;
	@NotEmpty
	private String faixaEtaria;
	@NotEmpty
	private String valor;
	private boolean isLiberado;

	//@NotEmpty
	
	private String data;
	//@NotEmpty
	
	private String hora;
	
	@NotEmpty
	private String dono;

	/*
	 * private UsuarioCadastrado dono;
	 * 
	 * private List<UsuarioCadastrado> listInteresse = new ArrayList<>(); private
	 * List<UsuarioCadastrado> listConfirmado = new ArrayList<>();
	 */
	public EventoDTOpost_put() {
	}

	
	
	public EventoDTOpost_put(Integer id, @NotEmpty String nome, @NotEmpty String tipo, @NotEmpty String endereco,
			@NotEmpty String cidade, @NotEmpty String estado, @NotEmpty String valores_tipo, @NotEmpty String descricao,
			@NotEmpty String faixaEtaria, @NotEmpty String valor, 
			@NotEmpty String dono, boolean isLiberado) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.valores_tipo = valores_tipo;
		this.descricao = descricao;
		this.faixaEtaria = faixaEtaria;
		this.valor = valor;
		this.isLiberado = isLiberado;
		
		
		this.dono = dono;
	}



	public EventoDTOpost_put(Evento e) {
		super();
		this.id = e.getId();
		this.nome = e.getNome();
		//this.dono = e.getDono();
		this.tipo = e.getTipo();
		this.endereco = e.getEndereco();
		this.cidade = e.getCidade();
		this.estado = e.getEstado();
		this.valores_tipo = e.getValores_tipo();
		this.descricao = e.getDescricao();
		this.faixaEtaria = e.getFaixaEtaria();
		this.valor = e.getValor();
		this.isLiberado = e.isLiberado();

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValores_tipo() {
		return valores_tipo;
	}

	public void setValores_tipo(String valores_tipo) {
		this.valores_tipo = valores_tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public boolean isLiberado() {
		return isLiberado;
	}

	public void setLiberado(boolean isLiberado) {
		this.isLiberado = isLiberado;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	

}
