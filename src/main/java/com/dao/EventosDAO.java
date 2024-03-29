package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.Evento;

@Repository
public interface EventosDAO extends JpaRepository<Evento, Integer>{

}
