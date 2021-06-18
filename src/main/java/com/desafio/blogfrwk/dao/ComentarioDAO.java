package com.desafio.blogfrwk.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.blogfrwk.bean.Comentario;

@Repository
public interface ComentarioDAO extends CrudRepository<Comentario, Long>{

}
