package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
		
		usu.setUsername(usu2.getUsername());
		usu.setCpf_cnpj(usu2.getCpf_cnpj());
		usu.setEmail(usu2.getEmail());
		usu.setIdade(usu2.getIdade());
		usu.setNome(usu2.getNome());
		
	}
	
	public Page<UsuarioCadastrado> buscarPages(Integer page, Integer linesPP, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPP, Direction.valueOf(direction), orderBy);
		
		return Dao.findAll(pageRequest);
	}


	public UsuarioCadastrado adicionarEvento(UsuarioCadastrado usuario) {
			
		return Dao.save(usuario);
	}


	public void delete(String id) throws Exception {
		buscarUsuario(id);
		
		try {
			Dao.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Não foi possivel excluir, objs relacionados");
		}
		
	}
}
