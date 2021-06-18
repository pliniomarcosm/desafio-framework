package com.desafio.blogfrwk.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.blogfrwk.bean.Post;

@Repository
public interface PostDAO extends CrudRepository<Post, Long>{

}
