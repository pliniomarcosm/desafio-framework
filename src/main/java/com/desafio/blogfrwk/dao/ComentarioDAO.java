package com.desafio.blogfrwk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.blogfrwk.bean.Comentario;

public interface ComentarioDAO extends JpaRepository<Comentario, Long>{

}
