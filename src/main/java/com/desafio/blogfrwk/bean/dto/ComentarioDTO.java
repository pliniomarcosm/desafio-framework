package com.desafio.blogfrwk.bean.dto;

import com.desafio.blogfrwk.bean.Post;

//Transient
public class ComentarioDTO {
	private String comentarioConteudo;
	private Post post;
	
	public String getComentarioConteudo() {
		return comentarioConteudo;
	}
	public void setComentarioConteudo(String comentarioConteudo) {
		this.comentarioConteudo = comentarioConteudo;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
