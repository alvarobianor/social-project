package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.UsuarioCadastrado;

@Repository
public interface UsuarioCadastradoDAO extends JpaRepository<UsuarioCadastrado, String>{

}
