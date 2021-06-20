package com.desafio.blogfrwk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.blogfrwk.bean.Foto;

public interface FotoDAO extends JpaRepository<Foto, Long>{

}
