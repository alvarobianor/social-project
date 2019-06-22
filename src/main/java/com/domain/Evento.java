package com.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.domain.DTO.UsuarioCadastradoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String tipo;
	private String endereco;
	private String cidade;
	private String estado;
	private String valores_tipo;
	private String descricao;
	private String faixaEtaria;
	private String valor;
	private boolean isLiberado;
	
	@JsonFormat(pattern = "dd/MM/aaaa")
	private Date data;
	@JsonFormat(pattern = "HH:mm:SS")
	private Date hora;
	
	
	@ManyToOne
	@JoinColumn(name = "id_dono")
	private UsuarioCadastrado dono;
	//private List<UsuarioCadastrado> dono = new ArrayList();
	
	
	@ManyToMany
	@JoinTable(name = "ListaInteresse",
	joinColumns = @JoinColumn(name = "id_evento"),
	inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private List<UsuarioCadastrado> listaInteresse = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(name = "ListaConfirmada",
	joinColumns = @JoinColumn(name = "id_evento"),
	inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private List<UsuarioCadastrado> listaConfirmada = new ArrayList<>();

	public Evento() {}
	
	
	public Evento(Integer id, String nome, String tipo, String endereco, String cidade, String estado, String valores,
			String descricao, String faixaEtaria, String valor, Date data, Date hora, UsuarioCadastrado dono) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.valores_tipo = valores;
		this.descricao = descricao;
		this.faixaEtaria = faixaEtaria;
		this.valor = valor;
		this.data = data;
		this.hora = hora;
		this.dono = dono;
		this.isLiberado = false;
	}


	public UsuarioCadastrado getDono() {
		return dono;
	}


	public void setDono(UsuarioCadastrado dono) {
		this.dono = dono;
	}

	public String getValores_tipo() {
		return valores_tipo;
	}


	public void setValores_tipo(String valores_tipo) {
		this.valores_tipo = valores_tipo;
	}


	public boolean isLiberado() {
		return isLiberado;
	}


	public void setLiberado(boolean isLiberado) {
		this.isLiberado = isLiberado;
	}

	
	public List<UsuarioCadastrado> getListaInteresse() {
		return listaInteresse;
	}

	
	public void setListaInteresse(List<UsuarioCadastrado> listaInteresse) {
		this.listaInteresse = listaInteresse;
	}

	
	public List<UsuarioCadastrado> getListaConfirmada() {
		return listaConfirmada;
	}


	public void setListaConfirmada(List<UsuarioCadastrado> listaConfirmada) {
		this.listaConfirmada = listaConfirmada;
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

	public String getValores() {
		return valores_tipo;
	}

	public void setValores(String valores) {
		this.valores_tipo = valores;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
