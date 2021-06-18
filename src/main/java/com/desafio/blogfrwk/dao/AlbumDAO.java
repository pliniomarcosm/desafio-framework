package com.desafio.blogfrwk.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.blogfrwk.bean.Album;

@Repository
public interface AlbumDAO extends CrudRepository<Album, Long>{

}
