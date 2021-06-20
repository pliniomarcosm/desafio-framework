package com.desafio.blogfrwk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.blogfrwk.bean.Album;

@Repository
public interface AlbumDAO extends JpaRepository<Album, Long>{

}