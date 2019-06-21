package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsuarioCadastradoDAO;
import com.domain.UsuarioCadastrado;
import com.exceptions.ObjectNotFoundException;

@Service
public class UsuarioCadastradoServices {

	@Autowired
	UsuarioCadastradoDAO Dao;
	
	public UsuarioCadastrado buscarUsuario(String id) throws ObjectNotFoundException{
		Optional<UsuarioCadastrado> usuario = Dao.findById(id);
		
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
