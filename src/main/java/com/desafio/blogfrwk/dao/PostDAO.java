package com.desafio.blogfrwk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.blogfrwk.bean.Post;

@Repository
public interface PostDAO extends JpaRepository<Post, Long>{

}
