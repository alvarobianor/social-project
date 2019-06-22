package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsuarioCadastradoDAO;
import com.domain.UsuarioCadastrado;
import com.domain.DTO.UsuarioCadastradoDTO;
import com.exceptions.ObjectNotFoundException;

@Service
public class UsuarioCadastradoServices {

	@Autowired
	UsuarioCadastradoDAO Dao;
	
	public UsuarioCadastrado buscarUsuario(String id) throws ObjectNotFoundException{
		Optional<UsuarioCadastrado> usuario = Dao.findById(id);
		
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public UsuarioCadastrado atualizar(UsuarioCadastrado usuario) {
		
		buscarUsuario(usuario.getUsername());
		
		return Dao.save(usuario);
		
	}
	
	
	public void atualizaSemPerder(UsuarioCadastrado usu, UsuarioCadastrado usu2) {
		
		usu.setCpf_cnpj(usu2.getCpf_cnpj());
		usu.setEmail(usu2.getEmail());
		usu.setIdade(usu2.getIdade());
		usu.setNome(usu2.getNome());
		
	}
}
