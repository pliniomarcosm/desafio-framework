package com.desafio.blogfrwk.bean.dto;

import com.desafio.blogfrwk.bean.Comentario;
import com.desafio.blogfrwk.bean.Post;

public class PostDTO {
	
	private Post post; 
	private Comentario comentario;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Comentario getComentario() {
		return comentario;
	}
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
}
